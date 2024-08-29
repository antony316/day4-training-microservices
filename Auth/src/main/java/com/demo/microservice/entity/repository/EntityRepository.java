package com.demo.microservice.entity.repository;

import com.demo.microservice.entity.model.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<Entity, Long> {

}
