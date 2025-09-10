package cn.itcast.mq.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    void topicExchangeTest() {
        String exchangeName = "itcast.topic";
        String msg = "hello, topic!";
        rabbitTemplate.convertAndSend(exchangeName,"china.msg",msg);
    }

    //注册消息转换器后spring会自动将消息对象序列化json对象
    @Test
    public void testSendObject() {
        // 1.发送消息
        Map<String,String> msg = new HashMap<>();
        String queueName = "object.queue";
        String message = "hello, rabbitmq!";
        msg.put(queueName,message);
        rabbitTemplate.convertAndSend(queueName, msg);
    }
}
