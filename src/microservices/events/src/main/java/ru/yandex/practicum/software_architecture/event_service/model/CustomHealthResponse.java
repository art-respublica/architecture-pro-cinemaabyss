package ru.yandex.practicum.software_architecture.event_service.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class CustomHealthResponse {

    private Boolean status;
}
