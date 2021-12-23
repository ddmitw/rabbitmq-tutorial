package com.ddmit.rabbitmqdemo.receiver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "orderQueue")
public class OrderMqReceiver {

    private static final Logger logger = LoggerFactory.getLogger(OrderMqReceiver.class);

    @RabbitHandler
    public void process(String message) {
        try {
            // 模拟处理过程
            Thread.sleep(5000);
            logger.info("OrderMqReceiver收到消息开始用户下单流程: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
