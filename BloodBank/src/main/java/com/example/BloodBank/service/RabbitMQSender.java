package com.example.BloodBank.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.BloodBank.dto.MessageDto;

@Service
public class RabbitMQSender {

    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public RabbitMQSender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${custom.rabbitmq.exchange}")
    String exchange;

    @Value("${custom.rabbitmq.routingkey}")
    private String routingKey;

    public void send(MessageDto message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
