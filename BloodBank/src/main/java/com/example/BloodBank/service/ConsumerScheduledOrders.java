package com.example.BloodBank.service;

import com.example.BloodBank.model.ScheduledOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerScheduledOrders {

    @RabbitListener(queues = "${custom.rabbitmq.scheduledOrdersQueue}")
    public void handler(String message){
        System.out.println("GOT MESSAGE!");
        System.out.println(message);

        String[] split = message.split("\"");
        System.out.println("splitted: ");
        for (String a : split)
            System.out.println(a);
        ScheduledOrder so = new ScheduledOrder();
        so.setDayOfMonth(Integer.parseInt(split[2].substring(1, 2)));
        so.setAplus(Integer.parseInt(split[4].substring(1, 2)));
        so.setBplus(Integer.parseInt(split[6].substring(1, 2)));
        so.setBankEmail(split[9]);
        so.setHospitalEmail(split[17]);
        System.out.println(so.toString());
    }
}
