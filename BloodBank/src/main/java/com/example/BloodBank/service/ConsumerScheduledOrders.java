package com.example.BloodBank.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerScheduledOrders {

    @RabbitListener(queues = "${custom.rabbitmq.scheduledOrdersQueue}")
    public void handler(String message){
        System.out.println("GOT MESSAGE!");
        System.out.println(message);
    }
}
