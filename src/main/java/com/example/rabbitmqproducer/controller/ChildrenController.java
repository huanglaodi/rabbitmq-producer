package com.example.rabbitmqproducer.controller;

import com.example.rabbitmqproducer.dom.Children;
import com.example.rabbitmqproducer.service.ChildrenMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ch")
public class ChildrenController {

    @Autowired
    public ChildrenMapperService childrenMapperService;

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
        System.out.println("222");
        int i = childrenMapperService.updateById(children);
        System.out.println("333");
        return childrenMapperService.selectById(children.getId());

    }

}
