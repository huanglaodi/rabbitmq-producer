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
        QueryWrapper<Children> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","小红");
        return childrenMapper.selectList(queryWrapper);
    }


    public int updateById(Children children) {
        int num = childrenMapper.updateById(children);
        System.out.println(num);
        return num;
    }


    public Children selectById(String id) {
        QueryWrapper<Children> queryWrapper = new QueryWrapper<Children>();
        queryWrapper.eq("id",id);
        return childrenMapper.selectOne(queryWrapper);
    }

    public List<Children> selectAll(){
        QueryWrapper<Children> queryWrapper = new QueryWrapper<Children>();
        List<Children> childrenList = childrenMapper.selectList(queryWrapper);
        return childrenList;
    }

    public List<Children> selects(){
        return childrenMapper.selects();
    }

    public List<String> getAllIds(){
        return childrenMapper.getAllIds();
    }
}
