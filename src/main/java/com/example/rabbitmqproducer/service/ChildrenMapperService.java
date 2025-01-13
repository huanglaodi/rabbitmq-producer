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

    public int addChildrens() {
        Children children = new Children();
        for(int i=1;i<=10000;i++){
            children.setName("小赵"+i);
            children.setScore((int)(Math.random()*100));
            children.setOkStatus(((int)(Math.random()*10))%2==1?false:true);
            children.setAddress("广州"+i);
            childrenMapper.addChildren(children);
        }

        return 1;
    }

    public Children selectById(int id) {
        QueryWrapper<Children> queryWrapper = new QueryWrapper<Children>();
        queryWrapper.eq("id",id);
        return childrenMapper.selectOne(queryWrapper);
    }

    public List<Children> selectAll(){
        QueryWrapper<Children> queryWrapper = new QueryWrapper<Children>();
        List<Children> childrenList = childrenMapper.selectList(queryWrapper);
        return childrenList;
    }

    public List<Children> selects(String id){
        return childrenMapper.selects(id);
    }

    public List<Integer> getAllIds(){
        return childrenMapper.getAllIds();
    }
}
