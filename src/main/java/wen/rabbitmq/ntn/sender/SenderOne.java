package wen.rabbitmq.ntn.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderOne {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "multi Queue: " + i;
        System.out.println("Sender one: " + context);
        this.rabbitTemplate.convertAndSend("many to many", context);
    }

}
