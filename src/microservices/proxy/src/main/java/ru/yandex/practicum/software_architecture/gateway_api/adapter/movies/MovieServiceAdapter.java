package ru.yandex.practicum.software_architecture.gateway_api.adapter.movies;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.gateway_api.model.Movie;
import ru.yandex.practicum.software_architecture.gateway_api.model.MovieInput;
import ru.yandex.practicum.software_architecture.gateway_api.model.error.GatewayApiException;
import ru.yandex.practicum.software_architecture.gateway_api.service.MigrationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceAdapter {

    private final MovieServiceFeignClient serviceFeignClient;
    private final MovieMonolithFeignClient monolithFeignClient;
    private final MigrationService migrationService;

    public List<Movie> getMovies() {
        try {
            if (migrationService.checkSendMoviesRequestToService()) {
                return serviceFeignClient.getMovies();
            } else {
                return monolithFeignClient.getMovies();
            }
        } catch (FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }

    public Movie createMovie(MovieInput movieInput) {
        try {
            if (migrationService.checkSendMoviesRequestToService()) {
                return serviceFeignClient.createMovie(movieInput);
            } else  {
                return monolithFeignClient.createMovie(movieInput);
            }
        } catch (FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }

    public Health getMoviesServiceHealth() {
        try {
            return serviceFeignClient.getMoviesServiceHealth();
        } catch (FeignException exception) {
            throw new GatewayApiException(exception);
        }
    }
}
