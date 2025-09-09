package cn.itcast.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置类中注册交换机，队列还有绑定关系
//比较繁琐
@Configuration
public class ExchangeConfig {
    //创建交换机，并交给Spring容器管理，Spring会自动注册到RabbitMQ中
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("itcast.fanout");
    }
    //创建队列，并交给Spring容器管理，Spring会自动注册到RabbitMQ中
    @Bean
    public Queue fanoutQueue1(){
        return new Queue("fanout.queue1");
    }
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("fanout.queue2");
    }
    //绑定交换机和队列的关系，并交给Spring容器管理，Spring会自动注册到RabbitMQ中
    @Bean
    public Binding fanoutBinding1(FanoutExchange fanoutExchange,Queue fanoutQueue1){
        return BindingBuilder
                .bind(fanoutQueue1)
                .to(fanoutExchange);
    }
    @Bean
    public Binding fanoutBinding2(FanoutExchange fanoutExchange,Queue fanoutQueue2){
        return BindingBuilder
                .bind(fanoutQueue2)
                .to(fanoutExchange);
    }
}
