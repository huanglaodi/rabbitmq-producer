package com.example.rabbitmqproducer.controller;


import com.example.rabbitmqproducer.util.ShengXiaoTool;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/shenXiao")
public class ShenXiaoController {


    @PostMapping("/getShenXiao")
    public Map getShenXiao(@RequestBody Map map) throws Exception {
        System.out.println("post11");
        Map map1 = new HashMap();
        String message = ShengXiaoTool.getJson(map);
        map1.put("message",message);
        System.out.println(message);
        return map1;
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("laomaocece");
        return "test111";
    }

}
