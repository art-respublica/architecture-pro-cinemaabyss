package ru.yandex.practicum.software_architecture.gateway_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

@Data
@Builder
@Jacksonized
public class SubscriptionInput {

    @JsonProperty(value = "user_id", required = true)
    private Integer userId;

    @JsonProperty(value = "plan_type", required = true)
    private String planType;

    @JsonProperty(value = "start_date", required = true)
    private Instant startDate;

    @JsonProperty(value = "end_date", required = true)
    private Instant endDate;
}
