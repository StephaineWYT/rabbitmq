package wen.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

    @Bean
    public Queue StephanieQueue() {
        return new Queue("Stephanie");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("many to many");
    }

    @Bean
    public Queue UserQueue() {
        return new Queue("user");
    }
}
