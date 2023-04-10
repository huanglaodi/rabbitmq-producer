package com.example.rabbitmqproducer.dom;

import lombok.Data;

import java.io.Serializable;

@Data
public class Children implements Serializable {

    private static final long serialVersionUID = 0;

    private String id;

    private String name;

    private Integer score;


}
