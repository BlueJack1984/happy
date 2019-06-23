package com.example.happy.controller;

import com.example.happy.entity.Message;
import com.example.happy.producers.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rabbitmq")
@Slf4j
public class RabbitmqController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/message/send")
    public String send(@Valid Message message) {
        String result = producerService.produce(message.getContent());
        return result;
    }
}
