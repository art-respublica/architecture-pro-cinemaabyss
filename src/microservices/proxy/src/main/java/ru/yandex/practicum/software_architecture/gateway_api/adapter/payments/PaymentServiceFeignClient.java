package ru.yandex.practicum.software_architecture.gateway_api.adapter.payments;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.practicum.software_architecture.gateway_api.model.Payment;
import ru.yandex.practicum.software_architecture.gateway_api.model.PaymentInput;

import java.util.List;

@FeignClient(name = "paymentServiceClient", url = "${monolith.url}")
public interface PaymentServiceFeignClient {

    @GetMapping("/api/payments")
    List<Payment> getPayments();

    @PostMapping("/api/payments")
    Payment createPayment(@RequestBody PaymentInput paymentInput);
}
