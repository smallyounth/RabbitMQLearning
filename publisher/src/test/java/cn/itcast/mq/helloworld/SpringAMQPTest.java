package cn.itcast.mq.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringAMQPTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage() {
        // 1.发送消息
        String queueName = "simple.queue";
        String message = "hello, rabbitmq!";
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
