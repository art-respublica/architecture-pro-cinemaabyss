package ru.yandex.practicum.software_architecture.gateway_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.gateway_api.adapter.payments.PaymentServiceAdapter;
import ru.yandex.practicum.software_architecture.gateway_api.model.Payment;
import ru.yandex.practicum.software_architecture.gateway_api.model.PaymentInput;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/payments")
public class PaymentsController {

    private final PaymentServiceAdapter adapter;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<Payment> getPayments() {
        return adapter.getPayments();
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    Payment createPayment(@RequestBody PaymentInput paymentInput) {
        return adapter.createPayment(paymentInput);
    }
}
