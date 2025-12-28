package ru.yandex.practicum.software_architecture.gateway_api.adapter.users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.practicum.software_architecture.gateway_api.model.User;
import ru.yandex.practicum.software_architecture.gateway_api.model.UserInput;

import java.util.List;

@FeignClient(name = "userServiceClient", url = "${monolith.url}")
public interface UserServiceFeignClient {

    @GetMapping("/api/users")
    List<User> getUsers();

    @PostMapping("/api/users")
    User createUser(@RequestBody UserInput userInput);
}
