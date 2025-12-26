package ru.yandex.practicum.software_architecture.gateway_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.gateway_api.adapter.users.UserServiceAdapter;
import ru.yandex.practicum.software_architecture.gateway_api.model.User;
import ru.yandex.practicum.software_architecture.gateway_api.model.UserInput;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class UsersController {

    private final UserServiceAdapter adapter;

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getUsers() {
        return adapter.getUsers();
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    User createUser(@RequestBody UserInput userInput) {
        return adapter.createUser(userInput);
    }
}
