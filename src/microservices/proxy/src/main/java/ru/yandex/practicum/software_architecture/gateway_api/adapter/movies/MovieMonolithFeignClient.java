package ru.yandex.practicum.software_architecture.gateway_api.adapter.movies;

import org.springframework.boot.actuate.health.Health;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.practicum.software_architecture.gateway_api.model.Movie;
import ru.yandex.practicum.software_architecture.gateway_api.model.MovieInput;

import java.util.List;

@FeignClient(name = "movieMonolithClient", url = "${monolith.url}")
public interface MovieMonolithFeignClient {

    @GetMapping("/api/movies")
    List<Movie> getMovies();

    @PostMapping("/api/movies")
    Movie createMovie(@RequestBody MovieInput movieInput);

    @GetMapping("/api/movies/health")
    Health getMoviesServiceHealth();
}
