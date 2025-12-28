package ru.yandex.practicum.software_architecture.gateway_api.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class MovieInput {

    private String title;
    private String description;
    private List<String> genres;
    private Double rating;
}
