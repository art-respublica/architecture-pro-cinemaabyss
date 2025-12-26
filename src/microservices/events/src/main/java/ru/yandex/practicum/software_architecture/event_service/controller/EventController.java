package ru.yandex.practicum.software_architecture.event_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.event_service.model.*;
import ru.yandex.practicum.software_architecture.event_service.service.EventService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/events")
public class EventController {

    private final EventService eventService;

    @PostMapping(value = "/movie",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    EventResponse createMovieEvent(@RequestBody MovieEvent movieEvent) {
        return eventService.createMovieEvent(movieEvent);
    }

    @PostMapping(value = "/user",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    EventResponse createUserEvent(@RequestBody UserEvent userEvent) {
        return eventService.createUserEvent(userEvent);
    }

    @PostMapping(value = "/payment",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    EventResponse createPaymentEvent(@RequestBody PaymentEvent paymentEvent) {
        return eventService.createPaymentEvent(paymentEvent);
    }

    @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    CustomHealthResponse getEventsServiceHealth() {
        return CustomHealthResponse.builder().status(true).build();
    }
}
