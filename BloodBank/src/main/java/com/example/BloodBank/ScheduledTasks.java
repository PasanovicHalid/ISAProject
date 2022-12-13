package com.example.BloodBank;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.BloodBank.dto.MessageDto;
import com.example.BloodBank.service.RabbitMQSender;

import java.util.Date;
import java.util.UUID;

@Component
public class ScheduledTasks {

    private final RabbitMQSender rabbitMQSender;

    @Autowired
    public ScheduledTasks(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }
//    @Scheduled(fixedRate = 3000)
//    public void sendMessage() {
//       MessageDto message = new MessageDto("AAA Random message from Java client: " + UUID.randomUUID().toString(),
//               new Date());
//        rabbitMQSender.send(message);
//        System.out.println("Sent :" + message.toString());
//    }
}
