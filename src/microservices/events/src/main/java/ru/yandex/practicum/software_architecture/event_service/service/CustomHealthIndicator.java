package ru.yandex.practicum.software_architecture.event_service.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

@Service
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (performCustomCheck()) {
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
