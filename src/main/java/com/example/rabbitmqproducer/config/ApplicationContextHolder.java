package com.example.rabbitmqproducer.config;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
/**
 * 在spring中，只要实现或者继承xxAware接口或者类，在实例该对象时，
 * 会调用实现xxAware接口的类的方法，把参数传递
 */
/**
 * --效率，是成功的核心关键--
 * 在spring中获取非spring管理的bean对象
 * @Author lzl
 * @Date 2023/3/9 08:00
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    //spring容器
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }

    public static RedisTemplate getRedisTemplate(){
        return ApplicationContextHolder.applicationContext
                .getBean("redisTemplate",RedisTemplate.class);
    }
}


