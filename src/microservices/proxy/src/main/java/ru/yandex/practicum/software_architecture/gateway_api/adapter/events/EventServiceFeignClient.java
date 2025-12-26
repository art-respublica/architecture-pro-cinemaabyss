package ru.yandex.practicum.software_architecture.gateway_api.adapter.events;

import org.springframework.boot.actuate.health.Health;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.practicum.software_architecture.gateway_api.model.EventResponse;
import ru.yandex.practicum.software_architecture.gateway_api.model.MovieEvent;
import ru.yandex.practicum.software_architecture.gateway_api.model.PaymentEvent;
import ru.yandex.practicum.software_architecture.gateway_api.model.UserEvent;

@FeignClient(name = "eventServiceClient", url = "${events-service.url}")
public interface EventServiceFeignClient {

    @PostMapping("/api/events/movie")
    EventResponse createMovieEvent(@RequestBody MovieEvent movieEvent);

    @PostMapping("/api/events/movie")
    EventResponse createUserEvent(@RequestBody UserEvent userEvent);

    @PostMapping("/api/events/movie")
    EventResponse createPaymentEvent(@RequestBody PaymentEvent paymentEvent);

    @GetMapping("/api/events/health")
    Health getEventsServiceHealth();
}
