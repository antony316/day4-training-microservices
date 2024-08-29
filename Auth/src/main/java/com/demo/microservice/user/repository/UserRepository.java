package com.demo.microservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.microservice.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}