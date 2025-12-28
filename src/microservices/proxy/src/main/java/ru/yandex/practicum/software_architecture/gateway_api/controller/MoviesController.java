package ru.yandex.practicum.software_architecture.gateway_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.gateway_api.adapter.movies.MovieServiceAdapter;
import ru.yandex.practicum.software_architecture.gateway_api.model.Movie;
import ru.yandex.practicum.software_architecture.gateway_api.model.MovieInput;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/movies")
public class MoviesController {

    private final MovieServiceAdapter adapter;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public List<Movie> getMovies() {
        return adapter.getMovies();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    Movie createMovie(@RequestBody MovieInput movieInput) {
        return adapter.createMovie(movieInput);
    }

    @GetMapping("/health")
    @ResponseStatus(code = HttpStatus.OK)
    Health getMoviesServiceHealth() {
        return adapter.getMoviesServiceHealth();
    }
}
