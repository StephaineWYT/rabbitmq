package wen.rabbitmq.otn.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "Stephanie")
public class ReceiverTwo {

    @RabbitHandler
    public void process(String Stephanie) {
        System.out.println("Receiver Two: " + Stephanie);
    }

}
