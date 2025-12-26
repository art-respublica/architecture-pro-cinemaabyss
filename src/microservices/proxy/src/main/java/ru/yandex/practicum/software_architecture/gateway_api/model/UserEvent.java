package ru.yandex.practicum.software_architecture.gateway_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

@Data
@Builder
@Jacksonized
public class UserEvent {

    @JsonProperty(value = "user_id")
    private Integer userId;

    private String username;

    private String email;

    private String action;

    private Instant timestamp;
}
