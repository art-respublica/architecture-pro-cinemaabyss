package ru.yandex.practicum.software_architecture.event_service.adapter.kafka.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.event_service.config.KafkaTopicConfig;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieEventConsumer {

    @KafkaListener(topics = KafkaTopicConfig.MOVIE_TOPIC_NAME, groupId = KafkaTopicConfig.CONSUMER_GROUP_ID)
    public void consume(String message) {
        log.info("Получено сообщение {} из топика {}", message, KafkaTopicConfig.MOVIE_TOPIC_NAME);
    }
}
