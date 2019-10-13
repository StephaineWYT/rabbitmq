package wen.rabbitmq.otn.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StephanieSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "Stephanie Queue: " + i;
        System.out.println("Sender: " + context);
        this.rabbitTemplate.convertAndSend("Stephanie", context);
    }

}
