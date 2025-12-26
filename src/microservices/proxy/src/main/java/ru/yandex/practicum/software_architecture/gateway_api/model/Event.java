package ru.yandex.practicum.software_architecture.gateway_api.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

@Data
@Builder
@Jacksonized
public class Event {

    private Integer id;
    private String type;
    private Instant timestamp;
    private Payload payload;

    @Data
    @Builder
    @Jacksonized
    public static class Payload {

    }
}
