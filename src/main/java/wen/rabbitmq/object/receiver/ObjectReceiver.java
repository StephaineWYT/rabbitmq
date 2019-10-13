package wen.rabbitmq.object.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import wen.rabbitmq.model.User;

@Component
@RabbitListener(queues = "user")
public class ObjectReceiver {

    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver Object: " + user);
    }
}
