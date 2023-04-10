package com.example.rabbitmqproducer.service;

import com.example.rabbitmqproducer.dom.Children;
import com.example.rabbitmqproducer.mapper.ChildrenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildrenMapperService implements ChildrenMapper {

    @Autowired
    public ChildrenMapper childrenMapper;

    @Override
    public List<Children> selectByName(String name) {
        return childrenMapper.selectByName(name);
    }

    @Override
    public int updateById(Children children) {
        System.out.print("service执行");
        int num = childrenMapper.updateById(children);
        System.out.println(num);
        return num;
    }

    @Override
    public Children selectById(String id) {
        return childrenMapper.selectById(id);
    }
}
