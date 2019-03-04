package com.sym.shopping.member.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQMessageSender implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MQMessageSender(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setMandatory(true);
    }

    public void send(String message) throws Exception {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId("10086");

        rabbitTemplate.convertAndSend(
                "test-exchange-direct",//交换机
                "my",//路由键
                message,//消息内容
                correlationData//消息唯一ID
        );
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            System.out.println("消息确认成功cause" + s);
        } else {
            //处理丢失的消息
            System.out.println("消息确认失败:" + correlationData.getId() + "#cause" + s);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText,
                                String exchange, String routingKey) {
        System.out.println("确认后回调return--message:"+new String(message.getBody())+",replyCode:"+replyCode+",replyText:"
                +replyText+",exchange:"+exchange+",routingKey:"+routingKey);
    }
}
