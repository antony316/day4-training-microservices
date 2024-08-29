package com.demo.microservice.auth.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfiguration {

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags("application", "entity-service");
    }
    
    @Bean
    public Counter successCounter(MeterRegistry meterRegistry) {
        return Counter.builder("entity_service_success")
                .description("Total number of successful requests")
                .tag("endpoint", "entity_service")
                .register(meterRegistry);
    }

    @Bean
    public Counter failedCounter(MeterRegistry meterRegistry) {
        return Counter.builder("entity_service_failed")
                .description("Total number of failed requests")
                .tag("endpoint", "entity_service")
                .register(meterRegistry);
    }
}
