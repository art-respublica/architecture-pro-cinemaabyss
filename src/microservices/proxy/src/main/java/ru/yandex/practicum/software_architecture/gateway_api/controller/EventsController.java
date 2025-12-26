package ru.yandex.practicum.software_architecture.gateway_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.gateway_api.adapter.events.EventServiceAdapter;
import ru.yandex.practicum.software_architecture.gateway_api.model.EventResponse;
import ru.yandex.practicum.software_architecture.gateway_api.model.MovieEvent;
import ru.yandex.practicum.software_architecture.gateway_api.model.PaymentEvent;
import ru.yandex.practicum.software_architecture.gateway_api.model.UserEvent;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/events")
public class EventsController {

    private final EventServiceAdapter adapter;

    @PostMapping(value = "/movie",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    EventResponse createMovieEvent(@RequestBody MovieEvent movieEvent) {
        return adapter.createMovieEvent(movieEvent);
    }

    @PostMapping(value = "/user",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    EventResponse createUserEvent(@RequestBody UserEvent movieInput) {
        return adapter.createUserEvent(movieInput);
    }

    @PostMapping(value = "/payment",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    EventResponse createPaymentEvent(@RequestBody PaymentEvent movieInput) {
        return adapter.createPaymentEvent(movieInput);
    }

    @GetMapping("/health")
    @ResponseStatus(code = HttpStatus.OK)
    Health getEventsServiceHealth() {
        return adapter.getEventsServiceHealth();
    }
}
