package wen.rabbitmq.ntn.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "many to many")
public class MultiReceiverOne {

    @RabbitHandler
    public void process(String object) {
        System.out.println("Receiver One: " + object);
    }

}
