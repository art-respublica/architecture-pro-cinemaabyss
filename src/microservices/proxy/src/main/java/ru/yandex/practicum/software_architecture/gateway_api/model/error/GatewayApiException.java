package ru.yandex.practicum.software_architecture.gateway_api.model.error;

public class GatewayApiException extends RuntimeException {

    public GatewayApiException(Throwable cause) {
        super(cause);
    }
}
