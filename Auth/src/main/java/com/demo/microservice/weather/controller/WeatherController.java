package com.demo.microservice.weather.controller;

import com.demo.microservice.weather.service.WeatherCircuitBreakerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherCircuitBreakerService weatherCircuitBreakerService;

    public WeatherController(WeatherCircuitBreakerService weatherCircuitBreakerService) {
        this.weatherCircuitBreakerService = weatherCircuitBreakerService;
    }

    @GetMapping("/{city}")
    public String getWeatherData(@PathVariable String city) {
        return weatherCircuitBreakerService.getWeatherData(city);
    }
}