package com.ddmit.rabbitmqdemo.service.impl;

import com.ddmit.rabbitmqdemo.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public String createOrderWithMq() {
        sendToOrderQueue("下单成功！");
        return "success";
    }

    /**
     * 向消息队列orderQueue发送消息
     *
     * @param message
     */
    private void sendToOrderQueue(String message) {
        logger.info("这就去通知消息队列开始下单：[{}]", message);
        this.rabbitTemplate.convertAndSend("orderQueue", message);
    }
}
