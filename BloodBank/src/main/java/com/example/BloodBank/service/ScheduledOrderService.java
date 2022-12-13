package com.example.BloodBank.service;

import com.example.BloodBank.excpetions.EntityDoesntExistException;
import com.example.BloodBank.model.ScheduledOrder;
import com.example.BloodBank.repository.ScheduledOrdersRepository;
import com.example.BloodBank.service.service_interface.IScheduledOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduledOrderService implements IScheduledOrderService {

    private final ScheduledOrdersRepository scheduledOrdersRepository;

    @Autowired
    public ScheduledOrderService(ScheduledOrdersRepository scheduledOrdersRepository){
        this.scheduledOrdersRepository = scheduledOrdersRepository;
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
}
