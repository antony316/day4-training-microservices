package com.demo.microservice.weather.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class WeatherCircuitBreakerService {

    private final MockExternalService mockExternalService;

    public WeatherCircuitBreakerService(MockExternalService mockExternalService) {
        this.mockExternalService = mockExternalService;
    }

    @CircuitBreaker(name = "weatherService", fallbackMethod = "fallback")
    public String getWeatherData(String city) {
        return mockExternalService.getWeatherData(city);
    }

    public String fallback(String city, Throwable throwable) {
        return "Fallback message: Unable to retrieve weather data";
    }
}