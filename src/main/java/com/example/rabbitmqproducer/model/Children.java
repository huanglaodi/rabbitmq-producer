package com.example.rabbitmqproducer.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@TableName(value="children_s")
@Data
public class Children implements Serializable {



    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer score;

    private Boolean okStatus;

    private String address;



}
