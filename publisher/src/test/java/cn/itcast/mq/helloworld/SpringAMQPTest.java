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

    @Test
    void fanoutExchangeTest() {
        String exchangeName = "itcast.fanout";
        String msg = "hello, consumers!";
        rabbitTemplate.convertAndSend(exchangeName,"",msg);
    }

    @Test
    void directExchangeTest() {
        String exchangeName = "itcast.direct";
        String msg = "hello, direct!";
        rabbitTemplate.convertAndSend(exchangeName,"blue",msg);
    }
}
