package ru.yandex.practicum.software_architecture.gateway_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

@Data
@Builder
@Jacksonized
public class PaymentEvent {

    @JsonProperty(value = "payment_id")
    private Integer paymentId;

    @JsonProperty(value = "user_id")
    private Integer userId;

    private Double amount;

    private String status;

    private Instant timestamp;

    @JsonProperty(value = "methodType")
    private Integer methodType;
}
