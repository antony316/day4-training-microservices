package com.demo.microservice.entity.service;

import com.demo.microservice.entity.model.Entity;
import com.demo.microservice.entity.repository.EntityRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityService {
    private static final Logger logger = LoggerFactory.getLogger(EntityService.class);

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private Counter successCounter;

    @Autowired
    private Counter failedCounter;

    public List<Entity> getAllEntities() {
        long startTime = System.currentTimeMillis();
        List<Entity> entities = entityRepository.findAll();
        long endTime = System.currentTimeMillis();
        logger.info("GET /api/entities - {} ms - HTTP Status: {}", endTime - startTime, HttpStatus.OK);
        successCounter.increment();
        return entities;
    }

    public Entity getEntityById(Long id) {
        long startTime = System.currentTimeMillis();
        Entity entity = entityRepository.findById(id).orElse(null);
        long endTime = System.currentTimeMillis();
        if (entity != null) {
            logger.info("GET /api/entities/{} - {} ms - HTTP Status: {}", id, endTime - startTime, HttpStatus.OK);
            successCounter.increment();
            return entity;
        } else {
            logger.warn("GET /api/entities/{} - {} ms - HTTP Status: {}", id, endTime - startTime, HttpStatus.NOT_FOUND);
            failedCounter.increment();
            return null;
        }
    }

    public Entity createEntity(Entity entity) {
        long startTime = System.currentTimeMillis();
        Entity savedEntity = entityRepository.save(entity);
        long endTime = System.currentTimeMillis();
        logger.info("POST /api/entities - {} ms - HTTP Status: {}", endTime - startTime, HttpStatus.CREATED);
        successCounter.increment();
        return savedEntity;
    }

    public Entity updateEntity(Long id, Entity entity) {
        long startTime = System.currentTimeMillis();
        Entity existingEntity = entityRepository.findById(id).orElse(null);
        if (existingEntity != null) {
            existingEntity.setName(entity.getName());
            existingEntity.setDescription(entity.getDescription());
            Entity updatedEntity = entityRepository.save(existingEntity);
            long endTime = System.currentTimeMillis();
            logger.info("PUT /api/entities/{} - {} ms - HTTP Status: {}", id, endTime - startTime, HttpStatus.OK);
            successCounter.increment();
            return updatedEntity;
        } else {
            long endTime = System.currentTimeMillis();
            logger.warn("PUT /api/entities/{} - {} ms - HTTP Status: {}", id, endTime - startTime, HttpStatus.NOT_FOUND);
            successCounter.increment();
            return null;
        }
    }

    public void deleteEntity(Long id) {
        long startTime = System.currentTimeMillis();
        entityRepository.deleteById(id);
        long endTime = System.currentTimeMillis();
        logger.info("DELETE /api/entities/{} - {} ms - HTTP Status: {}", id, endTime - startTime, HttpStatus.NO_CONTENT);
        successCounter.increment();
    }
}
