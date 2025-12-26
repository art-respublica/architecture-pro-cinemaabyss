package ru.yandex.practicum.software_architecture.gateway_api.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class User {

    private Integer id;
    private String username;
    private String email;
}
