package com.demo.microservice.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecureHelloController {
    @GetMapping("/secure-hello")
    public String secureHello() {
        return "Hello, Secure World";
    }
}

