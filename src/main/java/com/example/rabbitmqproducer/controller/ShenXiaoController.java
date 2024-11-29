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
    public Map getShenXiao(@RequestBody Map map) throws IOException {
        Map map1 = new HashMap();
        String message = ShengXiaoTool.getJson(map);
        map1.put("message",message);
        return map1;
    }

}
