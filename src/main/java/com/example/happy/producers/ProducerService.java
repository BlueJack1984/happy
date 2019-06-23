package com.example.happy.producers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 */
@Service
@Slf4j
public class ProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String produce(String message) {
        if(StringUtils.isEmpty(message)) {
            return "发送消息message为空";
        }
        amqpTemplate.convertAndSend("message", message);
        return "发送消息成功";
    }

}
