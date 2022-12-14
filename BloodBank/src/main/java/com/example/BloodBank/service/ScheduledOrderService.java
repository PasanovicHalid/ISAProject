package com.example.BloodBank.service;

import com.example.BloodBank.dto.FilledOrderDTO;
import com.example.BloodBank.excpetions.EntityDoesntExistException;
import com.example.BloodBank.model.ScheduledOrder;
import com.example.BloodBank.repository.ScheduledOrdersRepository;
import com.example.BloodBank.service.service_interface.IScheduledOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduledOrderService implements IScheduledOrderService {

    private final ScheduledOrdersRepository scheduledOrdersRepository;
    private final BloodBankService bloodBankService;
    private final RabbitMQSender rabbitMQSender;


    @Autowired
    public ScheduledOrderService(ScheduledOrdersRepository scheduledOrdersRepository,
                                 BloodBankService bloodBankService,
                                 RabbitMQSender rabbitMQSender){
        this.scheduledOrdersRepository = scheduledOrdersRepository;
        this.bloodBankService = bloodBankService;
        this.rabbitMQSender = rabbitMQSender;
    }

    @Override
    public ScheduledOrder Create(ScheduledOrder entity) throws Exception {
        return scheduledOrdersRepository.save(entity);
    }

    @Override
    public ScheduledOrder Read(Long id) throws Exception {
        Optional<ScheduledOrder> scheduledOrder = scheduledOrdersRepository.findById(id);
        if(scheduledOrder.isPresent()){
            return scheduledOrder.get();
        } else {
            throw new EntityDoesntExistException(id);
        }
    }

    @Override
    public ScheduledOrder Update(ScheduledOrder entity) throws Exception {
        return scheduledOrdersRepository.save(entity);
    }

    @Override
    public void Delete(ScheduledOrder entity) throws Exception {
        scheduledOrdersRepository.delete(entity);
    }

    @Override
    public List<ScheduledOrder> GetAll() throws Exception {
        return scheduledOrdersRepository.findAll();
    }
    public void sendOrders() throws Exception{
        List<ScheduledOrder> scheduledOrderList = GetAll();
        for (ScheduledOrder so : scheduledOrderList){
            //check if day is correct
            FilledOrderDTO fo = new FilledOrderDTO();
            fo.readScheduled(so);
            fo.setBankApi(bloodBankService.findByEmail(so.getBankEmail()).get().getAPIKey());
            //check if there is enough blood
            fo.setSent(true);
            rabbitMQSender.sendOrder(fo);

        }
    }
}
