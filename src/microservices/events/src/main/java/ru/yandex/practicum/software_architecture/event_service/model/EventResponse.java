package ru.yandex.practicum.software_architecture.event_service.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder(toBuilder = true)
@Jacksonized
public class EventResponse {

    private EventStatus status;
    private Integer partition;
    private Long offset;
    private Event event;
}
