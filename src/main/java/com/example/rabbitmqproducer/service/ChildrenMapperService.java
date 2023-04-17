package com.example.rabbitmqproducer.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.rabbitmqproducer.model.Children;
import com.example.rabbitmqproducer.mapper.ChildrenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildrenMapperService  {

    @Autowired
    public ChildrenMapper childrenMapper;


    public List<Children> selectByName(String name) {
        return childrenMapper.selectByName(name);
    }


    public int updateById(Children children) {
        System.out.print("service执行");
        int num = childrenMapper.updateById(children);
        System.out.println(num);
        return num;
    }


    public Children selectById(String id) {
        return childrenMapper.selectById(id);
    }

    public List<Children> selectAll(){
        QueryWrapper<Children> queryWrapper = new QueryWrapper<Children>();
        List<Children> childrenList = childrenMapper.selectList(queryWrapper);
        return childrenList;
    }
}
