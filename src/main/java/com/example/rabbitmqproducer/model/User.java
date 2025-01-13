package com.example.rabbitmqproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//生成set get方法
@AllArgsConstructor//有参构造函数
@NoArgsConstructor//无参构造函数
public class User {

    private String name;

    private Integer age;

    private String address;

}
