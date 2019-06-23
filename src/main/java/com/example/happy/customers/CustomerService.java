package com.example.happy.customers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 *
 */

@Service
@RabbitListener(queues = "message")
@Slf4j
public class CustomerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RabbitHandler
    public void custom(String message) {
        if(StringUtils.isEmpty(message)) {
            log.info("消息message为空");
            return;
        }
        log.info("&&&&&*****消费的消息为：" + message);
        log.info("&&&&&*****消息消费时间为：" + new Date());
    }
}
