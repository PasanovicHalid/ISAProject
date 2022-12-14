package com.example.BloodBank.service;

import com.example.BloodBank.dto.FilledOrderDTO;
import com.example.BloodBank.dto.NewsDTO;
import com.example.BloodBank.model.ScheduledOrder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RabbitMQSender {

    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public RabbitMQSender(AmqpTemplate rabbitTemplate) {

        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${custom.rabbitmq.exchange}")
    String exchange;


//    public void send(MessageDto message) {
//    	News news = new News();
//    	message.setContent(news);
//        rabbitTemplate.convertAndSend(exchange, "newsQueue", message);
//    }
    public void sendStringToQueue(String message, String queue){
        rabbitTemplate.convertAndSend(exchange, queue, message);
    }
    public void sendOrder(FilledOrderDTO filledOrderDTO){
        try{
            rabbitTemplate.convertAndSend(exchange, "sentOrdersQueue", filledOrderDTO);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
//    public void sendTo()
    public void sendNews(NewsDTO news){
        rabbitTemplate.convertAndSend(exchange, "newsQueue", news);
    }
}
