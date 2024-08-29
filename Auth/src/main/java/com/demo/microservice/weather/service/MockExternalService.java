package com.demo.microservice.weather.service;

import org.springframework.stereotype.Service;

@Service
public class MockExternalService {

    // Simulate with running service
    public String getWeatherData(String city) {
        // Simulate latency
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Simulate Failure
        if (Math.random() < 0.5) {
            throw new RuntimeException("External service failed");
        }

        return "Weather data for " + city;
    }

    // Test - Simulate Failure With Hard Code
    // public String getWeatherData(String city) {
    // throw new RuntimeException("Simulated failure");
    // }
}
