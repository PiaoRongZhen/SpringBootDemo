package com.example.demo.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/RocketMQ")
public class RocketMQController {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/send")
    public String send() {
        //send message synchronously
        rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");
        return "success";
    }

}
