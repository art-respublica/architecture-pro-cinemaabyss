package ru.yandex.practicum.software_architecture.gateway_api.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Perform your custom health check logic here
        boolean customServiceIsUp = performCustomCheck();

        if (customServiceIsUp) {
            return Health.up().build();
        } else {
            return Health.down().build();
        }
    }

    private boolean performCustomCheck() {
        // Example: Check a remote service, a file, or any specific condition
        // Return true if healthy, false otherwise
        return true;
    }
}
