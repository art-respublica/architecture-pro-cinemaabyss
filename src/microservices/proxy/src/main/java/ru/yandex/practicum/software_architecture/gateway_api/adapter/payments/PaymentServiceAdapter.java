package ru.yandex.practicum.software_architecture.gateway_api.adapter.payments;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.gateway_api.model.error.GatewayApiException;
import ru.yandex.practicum.software_architecture.gateway_api.model.Payment;
import ru.yandex.practicum.software_architecture.gateway_api.model.PaymentInput;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceAdapter {

    private final PaymentServiceFeignClient feignClient;

    public List<Payment> getPayments() {
        try {
            return feignClient.getPayments();
        } catch (FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }

    public Payment createPayment(PaymentInput paymentInput) {
        try {
            return feignClient.createPayment(paymentInput);
        } catch (
                FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }
}
