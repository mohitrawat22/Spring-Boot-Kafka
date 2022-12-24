package com.mor.orderservice.config;

/*
    Since the introduction of the AdminClient in the Kafka Clients library (version 0.11.0.0), we can create topics programmatically. 
    Spring Kafka is leveraging the Kafka AdminClient to create Kafka topics programmatically.
    Spring Boot will autoconfigure a AdminClientSpring Bean in your application context which will automatically add topics for all beans of type NewTopic.
    Spring Kafka version 2.3 introduced a TopicBuilder class to make the creation of such beans even more convenient!
    To create a Kafka topic programmatically introduce a configuration class that annotated with 
    @Configuration: this annotation indicates that the Java class can be used by Spring as a source of bean definitions.
    All methods annotated with @Bean: will return an object that should be registered as a bean in the Spring application context. 
    Spring Kafka will automatically add topics for all beans of type NewTopic.
    Next to the name of the Kafka topic name you can specify:
    -> the number of partitions for the topic
    -> the number of replicas for the topic
    -> assign replicas
*/

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    // spring bean for kafka topic
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(topicName)
                .build();
    }

}
