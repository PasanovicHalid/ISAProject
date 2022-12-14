package com.example.BloodBank.service;

import com.example.BloodBank.model.ScheduledOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerScheduledOrders {
    private final ScheduledOrderService scheduledOrderService;

    @Autowired
    public ConsumerScheduledOrders(ScheduledOrderService scheduledOrderService){
        this.scheduledOrderService = scheduledOrderService;
    }

    @RabbitListener(queues = "${custom.rabbitmq.scheduledOrdersQueue}")
    public void handler(String message){
        try{
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
            so.setABplus(Integer.parseInt(split[8].substring(1, 2)));
            so.setOplus(Integer.parseInt(split[10].substring(1, 2)));

            so.setAminus(Integer.parseInt(split[12].substring(1, 2)));
            so.setBminus(Integer.parseInt(split[14].substring(1, 2)));
            so.setABminus(Integer.parseInt(split[16].substring(1, 2)));
            so.setOminus(Integer.parseInt(split[18].substring(1, 2)));

            so.setBankEmail(split[21]);
            so.setHospitalEmail(split[29]);
            scheduledOrderService.Create(so);
            System.out.println(so.toString());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
