package ru.yandex.practicum.software_architecture.event_service.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    public static final String USER_TOPIC_NAME = "user-events";
    public static final String MOVIE_TOPIC_NAME = "movie-events";
    public static final String PAYMENT_TOPIC_NAME = "payment-events";

    public static final String CONSUMER_GROUP_ID = "consumer-group";

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic userTopic() {
        return new NewTopic(USER_TOPIC_NAME, 1, (short) 1);
    }

    @Bean
    public NewTopic movieTopic() {
        return new NewTopic(MOVIE_TOPIC_NAME, 1, (short) 1);
    }

    @Bean
    public NewTopic paymentTopic() {
        return new NewTopic(PAYMENT_TOPIC_NAME, 1, (short) 1);
    }
}
