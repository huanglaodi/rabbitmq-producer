
package com.example.rabbitmqproducer.config;

import com.example.rabbitmqproducer.model.Children;
import com.example.rabbitmqproducer.service.ChildrenMapperService;
import com.example.rabbitmqproducer.util.RedisUtil;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Configuration
public class RabbitmqConfigTopic {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    ChildrenMapperService childrenMapperService;

    @Autowired
    RedisUtil redisUtil;

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
   /* @Scheduled(fixedDelay = 500)
    public void sendDirectMessage() {
        String[] ids = {"1","2","3"};
        if(++num > 3){
            num = 1;
        }

        Children children = new Children();
        children = redisUtil.getObject(""+num,Children.class);
        if(ObjectUtils.isEmpty(children)){
            children = childrenMapperService.selectById(ids[num-1]);
            redisUtil.add(""+num,children);
            redisUtil.expire(""+num,20000, TimeUnit.MILLISECONDS);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("id", children.getId());
        map.put("name", children.getName());
        map.put("score", children.getScore());

        //rabbitTemplate.convertAndSend("topicExchange", "ab.cd", map);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", map);
        System.out.println("children: " + map);

    }*/


}
