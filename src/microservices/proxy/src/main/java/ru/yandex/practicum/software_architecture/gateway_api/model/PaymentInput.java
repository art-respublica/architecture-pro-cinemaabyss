package ru.yandex.practicum.software_architecture.gateway_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class PaymentInput {

    @JsonProperty(value = "user_id")
    private Integer userId;

    private Double amount;
}
