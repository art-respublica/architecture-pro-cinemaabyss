package ru.yandex.practicum.software_architecture.gateway_api.adapter.users;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.gateway_api.model.error.GatewayApiException;
import ru.yandex.practicum.software_architecture.gateway_api.model.User;
import ru.yandex.practicum.software_architecture.gateway_api.model.UserInput;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceAdapter {

    private final UserServiceFeignClient feignClient;

    public List<User> getUsers() {
        try {
            return feignClient.getUsers();
        } catch (FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }

    public User createUser(UserInput userInput) {
        try {
            return feignClient.createUser(userInput);
        } catch (FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }
}
