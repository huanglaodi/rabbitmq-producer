package com.example.rabbitmqproducer.controller;

import com.example.rabbitmqproducer.model.Children;
import com.example.rabbitmqproducer.service.ChildrenMapperService;
import com.example.rabbitmqproducer.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ch")
public class ChildrenController {

    @Autowired
    public ChildrenMapperService childrenMapperService;

    @Autowired
    public RedisUtil redisUtil;


    @ResponseBody
    @GetMapping
    @RequestMapping("/selectAll")
    public List<Children> selectAll() {

        return childrenMapperService.selectAll();

    }

    @ResponseBody
    @GetMapping
    @RequestMapping("/selectByName")
    public List<Children> selectByName(@RequestParam("name") String name) {

        return childrenMapperService.selectByName(name);

    }

    @ResponseBody
    @PostMapping
    @RequestMapping("/updateById")
    public Children updateById(@RequestBody Children children) {
        int i = childrenMapperService.updateById(children);
        System.out.println("333");
        return childrenMapperService.selectById(children.getId());

    }


    @ResponseBody
    @GetMapping
    @RequestMapping("/selectById")
    public Children selectById(@RequestParam("id") String id) {

          Children children = childrenMapperService.selectById(id);

        return children;

    }

}
