package com.mor.emailservice.kafka;

/*
    @KafkaListener allows a method to consume messages from Kafka topic(s).
    topics: The topics for this listener.
    groupId: Override the group.id property for the consumer factory with this value for this listener only.
    @KafkaListener designates a method as a listener in a KafkaMessageListenerContainer.
    A KafkaMessageListenerContainer is how Spring Boot connects and polls records from Kafka under the hood.
*/

import com.mor.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order event received in email-service => %s", orderEvent.toString()));
    }
}
