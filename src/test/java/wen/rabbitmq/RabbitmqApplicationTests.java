package wen.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wen.rabbitmq.fanout.send.FanoutSender;
import wen.rabbitmq.model.User;
import wen.rabbitmq.ntn.sender.SenderOne;
import wen.rabbitmq.ntn.sender.SenderTwo;
import wen.rabbitmq.object.sender.ObjectSender;
import wen.rabbitmq.otn.sender.StephanieSender;
import wen.rabbitmq.oto.sender.HelloSender;
import wen.rabbitmq.topic.sender.TopicSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private StephanieSender stephanieSender;

    @Autowired
    private SenderOne senderOne;

    @Autowired
    private SenderTwo senderTwo;

    @Autowired
    private ObjectSender objectSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    /**
     * one to one test
     *
     * @throws Exception
     */
    @Test
    public void hello() throws Exception {
        helloSender.send();
        Thread.sleep(1000L);
    }

    /**
     * one to N tests
     *
     * @throws Exception
     */
    @Test
    public void oneToN() throws Exception {
        for (int i = 0; i < 100; i++) {
            stephanieSender.send(i);
        }
        Thread.sleep(10000L);
    }

    /**
     * many to many tests
     *
     * @throws Exception
     */
    @Test
    public void manyToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            senderOne.send(i);
            senderTwo.send(i);
        }
        Thread.sleep(10000L);
    }

    /**
     * user test
     *
     * @throws Exception
     */
    @Test
    public void sendObject() throws Exception {
        User user = new User("Stephanie", "123");
        objectSender.send(user);
        Thread.sleep(1000L);
    }

    /**
     * 测试topic_rabbit
     *
     * @throws Exception
     */
    @Test
    public void topic() throws Exception {
        topicSender.send_one();
        Thread.sleep(5000L);
        System.out.println("-----send two-----");
        topicSender.send_two();
        Thread.sleep(1000L);
    }

    /**
     * fanout test
     *
     * @throws Exception
     */
    @Test
    public void fanoutSender() throws Exception {
        fanoutSender.send();
        Thread.sleep(1000L);
    }
}
