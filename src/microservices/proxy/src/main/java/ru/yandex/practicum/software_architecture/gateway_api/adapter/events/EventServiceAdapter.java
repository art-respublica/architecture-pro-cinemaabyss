package ru.yandex.practicum.software_architecture.gateway_api.adapter.events;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.gateway_api.model.EventResponse;
import ru.yandex.practicum.software_architecture.gateway_api.model.MovieEvent;
import ru.yandex.practicum.software_architecture.gateway_api.model.PaymentEvent;
import ru.yandex.practicum.software_architecture.gateway_api.model.UserEvent;
import ru.yandex.practicum.software_architecture.gateway_api.model.error.GatewayApiException;
import ru.yandex.practicum.software_architecture.gateway_api.service.MigrationService;

@Service
@RequiredArgsConstructor
public class EventServiceAdapter {

    private final EventServiceFeignClient serviceFeignClient;
    private final EventMonolithFeignClient monolithFeignClient;
    private final MigrationService migrationService;

    public EventResponse createMovieEvent(MovieEvent movieEvent) {
        try {
            if (migrationService.checkSendEventsRequestToService()) {
                return serviceFeignClient.createMovieEvent(movieEvent);
            } else {
                return monolithFeignClient.createMovieEvent(movieEvent);
            }
        } catch (FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }

    public EventResponse createUserEvent(UserEvent userEvent) {
        try {
            if (migrationService.checkSendEventsRequestToService()) {
                return serviceFeignClient.createUserEvent(userEvent);
            } else {
                return monolithFeignClient.createUserEvent(userEvent);
            }
        } catch (FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }

    public EventResponse createPaymentEvent(PaymentEvent paymentEvent) {
        try {
            if (migrationService.checkSendEventsRequestToService()) {
                return serviceFeignClient.createPaymentEvent(paymentEvent);
            } else {
                return monolithFeignClient.createPaymentEvent(paymentEvent);
            }
        } catch (FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }

    public Health getEventsServiceHealth() {
        try {
            return serviceFeignClient.getEventsServiceHealth();
        } catch (FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }
}
