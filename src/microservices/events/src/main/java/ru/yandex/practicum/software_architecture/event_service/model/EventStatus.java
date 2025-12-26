package ru.yandex.practicum.software_architecture.event_service.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventStatus {
    NEW("new"),
    SUCCESS("success"),
    COMPLETE("complete");

    private final String title;

    @JsonValue
    public String toValue() {
        return title;
    }
}
