package com.ddmit.rabbitmqdemo.controller;

import com.ddmit.rabbitmqdemo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping(value = "/createOrderWithMq")
    public String createOrderWithMq() {
        return orderService.createOrderWithMq();
    }
}
