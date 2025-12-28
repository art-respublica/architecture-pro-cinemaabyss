package ru.yandex.practicum.software_architecture.gateway_api.adapter.subscriptions;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.gateway_api.model.error.GatewayApiException;
import ru.yandex.practicum.software_architecture.gateway_api.model.Subscription;
import ru.yandex.practicum.software_architecture.gateway_api.model.SubscriptionInput;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceAdapter {

    private final SubscriptionServiceFeignClient feignClient;

    public List<Subscription> getSubscriptions() {
        try {
            return feignClient.getSubscriptions();
        } catch (FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }

    public Subscription createSubscription(SubscriptionInput subscriptionInput) {
        try {
            return feignClient.createSubscription(subscriptionInput);
        } catch (
                FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }
}
