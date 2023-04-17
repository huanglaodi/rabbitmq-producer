package com.example.rabbitmqproducer.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value="children_s")
public class Children implements Serializable {

    private String id;

    private String name;

    private Integer score;


}
