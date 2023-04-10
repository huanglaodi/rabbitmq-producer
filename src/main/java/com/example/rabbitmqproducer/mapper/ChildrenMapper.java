package com.example.rabbitmqproducer.mapper;

import com.example.rabbitmqproducer.dom.Children;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ChildrenMapper{

    List<Children> selectByName(@Param("name") String name);

    int updateById(@Param("children") Children children);

    Children selectById(@Param("id") String id);
}
