package ru.yandex.practicum.software_architecture.gateway_api.adapter.subscriptions;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.practicum.software_architecture.gateway_api.model.Subscription;
import ru.yandex.practicum.software_architecture.gateway_api.model.SubscriptionInput;

import java.util.List;

@FeignClient(name = "subscriptionServiceClient", url = "${monolith.url}")
public interface SubscriptionServiceFeignClient {

    @GetMapping("/api/subscriptions")
    List<Subscription> getSubscriptions();

    @PostMapping("/api/subscriptions")
    Subscription createSubscription(@RequestBody SubscriptionInput subscriptionInput);
}
