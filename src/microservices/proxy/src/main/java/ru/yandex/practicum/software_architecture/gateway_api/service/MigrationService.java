package ru.yandex.practicum.software_architecture.gateway_api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MigrationService {

    @Value("${movies.migration-percent}")
    private Integer migrationPercent;
    @Value("${gradual-migration}")
    private Boolean gradualMigration;

    public boolean checkSendMoviesRequestToService() {
        return getRandomPercent() < migrationPercent;
    }

    public boolean checkSendEventsRequestToService() {
        return Boolean.TRUE.equals(gradualMigration);
    }

    private int getRandomPercent() {
        return (int) (Math.random() * 100);
    }
}
