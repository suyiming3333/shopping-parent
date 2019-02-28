package com.sym.shopping.member.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
}
