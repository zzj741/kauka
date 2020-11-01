package com.kafuka.producer.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @RequestMapping("/sendMsg")
    public String sendMsg(@RequestParam String msg) {
        kafkaTemplate.send("testTopic", "0",  msg);
        return "This msg is : " + msg;
    }
}
