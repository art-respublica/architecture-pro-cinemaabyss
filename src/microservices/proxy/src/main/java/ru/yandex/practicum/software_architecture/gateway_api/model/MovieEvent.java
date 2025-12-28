package ru.yandex.practicum.software_architecture.gateway_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class MovieEvent {

    @JsonProperty(value = "movie_id")
    private Integer movieId;

    private String title;

    private String action;

    @JsonProperty(value = "user_id")
    private String userId;

    private List<String> genres;

    private String description;
}
