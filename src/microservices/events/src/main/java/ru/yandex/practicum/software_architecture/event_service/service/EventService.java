package ru.yandex.practicum.software_architecture.event_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.event_service.adapter.kafka.movie.MovieEventProducer;
import ru.yandex.practicum.software_architecture.event_service.adapter.kafka.payment.PaymentEventProducer;
import ru.yandex.practicum.software_architecture.event_service.adapter.kafka.user.UserEventProducer;
import ru.yandex.practicum.software_architecture.event_service.model.EventResponse;
import ru.yandex.practicum.software_architecture.event_service.model.MovieEvent;
import ru.yandex.practicum.software_architecture.event_service.model.PaymentEvent;
import ru.yandex.practicum.software_architecture.event_service.model.UserEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final ObjectMapper objectMapper;
    private final UserEventProducer userEventProducer;
    private final MovieEventProducer movieEventProducer;
    private final PaymentEventProducer paymentEventProducer;

    public EventResponse createMovieEvent(MovieEvent movieEvent) {
        return movieEventProducer.sendMessage(convertToJson(movieEvent));
    }

    public EventResponse createUserEvent(UserEvent userEvent) {
        return userEventProducer.sendMessage(convertToJson(userEvent));
    }

    public EventResponse createPaymentEvent(PaymentEvent paymentEvent) {
        return paymentEventProducer.sendMessage(convertToJson(paymentEvent));
    }

    public String convertToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException exception) {
            log.info("Ошибка преобразования объекта {} в строку: {}", object, exception.getMessage());
            return "{}";
        }
    }
}
