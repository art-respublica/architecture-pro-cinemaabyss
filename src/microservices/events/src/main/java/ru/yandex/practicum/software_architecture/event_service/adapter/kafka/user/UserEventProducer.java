package ru.yandex.practicum.software_architecture.event_service.adapter.kafka.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.event_service.config.KafkaTopicConfig;
import ru.yandex.practicum.software_architecture.event_service.model.EventResponse;
import ru.yandex.practicum.software_architecture.event_service.model.EventStatus;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public EventResponse sendMessage(String message) {
        log.info("Попытка отправки сообщения в топик {} : {}", KafkaTopicConfig.USER_TOPIC_NAME, message);
        CompletableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(KafkaTopicConfig.USER_TOPIC_NAME, message);

        try {
            SendResult<String, String> result = future.get();

            log.info("Отправлено сообщение {} с offset [{}] в топик {}",
                    message, result.getRecordMetadata().offset(), KafkaTopicConfig.USER_TOPIC_NAME);

            return EventResponse.builder()
                    .partition(result.getRecordMetadata().partition())
                    .offset(result.getRecordMetadata().offset())
                    .status(EventStatus.SUCCESS)
                    .build();
        } catch (ExecutionException | InterruptedException exception) {
            log.info("Ошибка при отправке сообщения [{}] : {}", message, exception.getMessage());
            return EventResponse.builder().status(EventStatus.NEW).build();
        }
    }
}
