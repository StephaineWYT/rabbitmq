package wen.rabbitmq.topic.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send_one() {
        String context = "Hi, I am message one";
        System.out.println("Sender: " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void send_two() {
        String context = "Hi, I am message two";
        System.out.println("Sender: " + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
    }

}
