package com.example.rabbitmqproducer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rabbitmqproducer.model.Children;
import com.example.rabbitmqproducer.util.RedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@CacheNamespace(implementation = RedisCache.class)
public interface ChildrenMapper extends BaseMapper<Children> {

    List<Children> selectByName(@Param("name") String name);

    int updateById(@Param("children") Children children);

    Children selectById(@Param("id") String id);


}
