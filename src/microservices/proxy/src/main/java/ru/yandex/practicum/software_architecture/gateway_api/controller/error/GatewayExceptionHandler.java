package ru.yandex.practicum.software_architecture.gateway_api.controller.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.yandex.practicum.software_architecture.gateway_api.model.error.GatewayApiException;
import ru.yandex.practicum.software_architecture.gateway_api.model.error.GatewayError;

@RestControllerAdvice
public class GatewayExceptionHandler extends ResponseEntityExceptionHandler {

    @SuppressWarnings("unused")
    @ExceptionHandler({GatewayApiException.class})
    public ResponseEntity<GatewayError> handleGatewayException(GatewayApiException exception) {
        GatewayError error = GatewayError.builder().error("Ошибка вызова внутреннего сервиса").build();

        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
