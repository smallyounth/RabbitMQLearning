package cn.itcast.mq.listener;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//rabbitMQ消息监听类,启动时能不断自动监听响应队列的消息
@Component
public class RabbitMessageListen {

//    @RabbitListener(queues = "simple.queue")
//    public void listenSimpleQueue(String message) {
//        System.out.println("消费者接收到消息：【" + message + "】");
//    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String message) {
        System.out.println("消费者接收到消息：【" + message + "】");
    }
    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String message) {
        System.out.println("消费者接收到消息：【" + message + "】");
    }

    //直接通过@RabbitListener注解来实现绑定关系，注册队列及交换机，相比配置类更加便捷
    // 可以指定队列、交换机、路由键
    //@Queue @Exchange注解 可以声明队列和交换机
    //@QueueBinding 注解 可以声明绑定关系并指定Routingkey
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("direct.queue1"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void listenDirectQueue1(String msg){
        System.out.println("消费者接收到direct.queue1的消息：【" + msg + "】");
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("direct.queue2"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void listenDirectQueue2(String msg){
        System.out.println("消费者接收到direct.queue2的消息：【" + msg + "】");
    }

}
