package com.example.rabbitmqproducer.util;
import com.example.rabbitmqproducer.config.ApplicationContextHolder;
import lombok.extern.java.Log;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 数据查询顺序：二级缓存 -> 一级缓存 -> 数据库
 * 我们在mybatis中指定了二级缓存，在mybatis启动会生成Cache对象，
 * 如果在该类使用@Autowired注入RedisTemplate是无法注入的，需要使用spring注入
 */
/**
 * --效率，是成功的核心关键--
 *
 * @Author lzl
 * @Date 2023/3/9 08:02
 */
@Log
public class RedisCache implements Cache{
    //RedisTemplate对象
    private RedisTemplate redisTemplate;

    //id相当于当前sql对应的cache的命名空间 namespace="com.qf.mapper.xxxMapper"
    private String id;

    //读写锁：多线程中可以共享锁，如果大家都是读操作，提高数据的读的并发能力
    //如果有一个人进行了写操作，其他人都不能进行读写操作了
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //获取RedisTemplate对象
    public RedisTemplate getRedisTemplate(){
        //判断
        if(redisTemplate == null){
            synchronized (RedisCache.class){
                if(redisTemplate == null){
                    RedisTemplate redisTemplate = ApplicationContextHolder.getRedisTemplate();
                    //设置key使用string类型的序列化方式
                    redisTemplate.setKeySerializer(RedisSerializer.string());
                    return redisTemplate;
                }
                return this.redisTemplate;
            }

        }
        return redisTemplate;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    //构造器
    public RedisCache(String id) {
        System.out.println("id："+id);
        this.id = id;
    }

    //id相当于当前sql对应的cache的命名空间
    @Override
    public String getId() {
        System.out.println("getId："+id);
        return id;
    }

    /**
     * 将结果放入缓存，当访问查询方法时调用，所以这里必须通过getRedisTemplate()方法来获取redisTemplate对象
     * @param key -> 命名空间 + sql + 参数 = 组成的字符串
     * @param value -> sql查询的结果
     */
    @Override
    public void putObject(Object key, Object value) {
        System.out.println("putObject中的key："+key);
        System.out.println("putObject中的value："+value);
        getRedisTemplate().opsForValue().set(key.toString(),value);
    }

    /**
     * 获取缓存中的数据，当访问查询方法时调用，所以这里必须通过getRedisTemplate()方法来获取redisTemplate对象
     * @param key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        System.out.println("getObject："+key);
        return getRedisTemplate().opsForValue().get(key.toString());
    }

    /**
     * 从缓存中移除数据，当访问查询方法时调用，所以这里必须通过getRedisTemplate()方法来获取redisTemplate对象
     * @param key
     * @return
     */
    @Override
    public Object removeObject(Object key) {
        System.out.println("removeObject："+key);
        return getRedisTemplate().delete(key.toString());
    }

    /**
     * 清空缓存
     */
    @Override
    public void clear() {
        System.out.println("clear");
        Set keys = getRedisTemplate().keys("*" + id + "*");
        System.out.println("清空缓存keys："+keys);
        getRedisTemplate().delete(keys);
    }

    /**
     * 获取缓存数据长度
     * @return
     */
    @Override
    public int getSize() {
        Set keys = getRedisTemplate().keys("*" + id + "*");
        return keys.size();
    }

}


