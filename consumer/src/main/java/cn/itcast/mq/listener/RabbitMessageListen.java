package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMessageListen {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String message) {
        System.out.println("消费者接收到消息：【" + message + "】");
    }
}
