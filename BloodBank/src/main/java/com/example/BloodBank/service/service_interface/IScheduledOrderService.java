package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.ScheduledOrder;

public interface IScheduledOrderService extends ICRUDService<ScheduledOrder> {
    public void sendOrders()throws  Exception;
}
