package wen.rabbitmq.object.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wen.rabbitmq.model.User;

@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user) {
        System.out.println("Object Sender: " + user.toString());
        this.rabbitTemplate.convertAndSend("user", user);
    }

}
