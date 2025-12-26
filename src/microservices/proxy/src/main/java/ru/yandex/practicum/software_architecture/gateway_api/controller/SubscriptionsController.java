package ru.yandex.practicum.software_architecture.gateway_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.gateway_api.adapter.subscriptions.SubscriptionServiceAdapter;
import ru.yandex.practicum.software_architecture.gateway_api.model.Subscription;
import ru.yandex.practicum.software_architecture.gateway_api.model.SubscriptionInput;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/subscriptions")
public class SubscriptionsController {

    private final SubscriptionServiceAdapter adapter;

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<Subscription> getSubscriptions() {
        return adapter.getSubscriptions();
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    Subscription createSubscription(@RequestBody SubscriptionInput subscriptionInput) {
        return adapter.createSubscription(subscriptionInput);
    }
}
