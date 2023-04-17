package com.example.rabbitmqproducer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rabbitmqproducer.model.Children;
import com.example.rabbitmqproducer.util.RedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
//@CacheNamespace注解搭配<cache-ref>解决注解与xml都能缓存
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface ChildrenMapper extends BaseMapper<Children> {

    List<Children> selects();

    List<String> getAllIds();

}
