package com.demo.microservice.entity.controller;

import com.demo.microservice.entity.model.Entity;
import com.demo.microservice.entity.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EntityController {
    @Autowired
    private EntityService entityService;

    @GetMapping("/entity")
    public ResponseEntity<List<Entity>> getAllEntities() {
        List<Entity> entities = entityService.getAllEntities();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/entity/{id}")
    public ResponseEntity<Entity> getEntityById(@PathVariable Long id) {
        Entity entities = entityService.getEntityById(id);
        if (entities == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @PostMapping("/entity")
    public ResponseEntity<Entity> createEntity(@RequestBody Entity entity) {
        Entity createdEntities = entityService.createEntity(entity);
        return new ResponseEntity<>(createdEntities, HttpStatus.CREATED);
    }

    @PutMapping("/entity/{id}")
    public ResponseEntity<Entity> updateEntity(@PathVariable Long id, @RequestBody Entity entity) {
        Entity updatedEntities = entityService.updateEntity(id, entity);
        if (updatedEntities == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedEntities, HttpStatus.OK);
    }

    @DeleteMapping("/entity/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        entityService.deleteEntity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
