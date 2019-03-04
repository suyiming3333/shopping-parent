package com.sym.shopping.message.queuelistener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "myqueue",durable = "true"),
        exchange = @Exchange(value = "test-exchange-direct",durable = "true"),
        key = "my")
)
public class MyQueueListener {
    @RabbitHandler//监听处理
    public void onOrderMessage(@Payload String message,//消息的内容
                               @Headers Map<String,Object> headers,//消息属性
                               Channel channel) throws IOException {//手工签收需要调用channel
        System.out.println("---------myqueue收到消息-----------");
        System.out.println("message recieved"+message);

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //手动签收,响应mq签收成功
        channel.basicAck(deliveryTag,false);//false不支持批量签收
        //channel.basicQos(1);

    }

}
