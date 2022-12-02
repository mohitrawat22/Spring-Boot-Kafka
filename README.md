# Spring-Boot-Kafka
Implementation of Kafka in Spring Boot project

In this project, we have 4 domains
1. base-domains: contains Order and OrderEvent which gets produced and consumed as message
2. email-service: works as consumer and consumes the message produced in the topic
3. stock-service: works as consumer and consumes the message produced in the topic
4. order-service: works as producer and produces the message in the topic
