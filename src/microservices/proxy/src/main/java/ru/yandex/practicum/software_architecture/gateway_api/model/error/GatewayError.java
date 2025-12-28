package ru.yandex.practicum.software_architecture.gateway_api.model.error;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class GatewayError {

    String error;
}
