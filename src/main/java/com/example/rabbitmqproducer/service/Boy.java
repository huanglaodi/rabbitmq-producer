package com.example.rabbitmqproducer.service;

public class Boy extends Chilldren{

    public Boy(String name,int age,String job){
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override
    public void getJob() {
        System.out.println("我叫"+name+",今年"+age+"岁，我是"+job);
    }


}
