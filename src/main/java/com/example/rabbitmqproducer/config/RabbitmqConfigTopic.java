
package com.example.rabbitmqproducer.config;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitmqConfigTopic {


    @Autowired
    RabbitTemplate rabbitTemplate;

    static int num = 0;

    //绑定键
    public final static String man = "topic.man";
    public final static String woman = "topic.woman";

    @Bean
    public Queue firstQueue() {
        return new Queue(RabbitmqConfigTopic.man);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(RabbitmqConfigTopic.woman);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }


    //将firstQueue和topicExchange绑定,而且绑定的键值为topic.man
    //这样只要是消息携带的路由键是topic.man,才会分发到该队列
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with("topic.man");
    }

    //将secondQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
    // 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }


    //定时一发消息
    /*@Scheduled(fixedDelay = 1000)
    public void sendDirectMessage() {
        String messageId = String.valueOf((int) (Math.random() * 10000));
        String messageData = "消息测试！第" + num++ + " 条信息";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);

        //rabbitTemplate.convertAndSend("topicExchange", "ab.cd", map);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", map);
        System.out.println("消息发送中" + map);

    }*/


}
