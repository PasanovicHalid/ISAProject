package com.example.BloodBank.controller;

import com.example.BloodBank.model.ScheduledOrder;
import com.example.BloodBank.service.ScheduledOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "api/scheduledorder")
public class ScheduledOrderController {
    private final ScheduledOrderService scheduledOrderService;

    @Autowired
    public ScheduledOrderController(ScheduledOrderService scheduledOrderService){
        this.scheduledOrderService = scheduledOrderService;
    }
    @GetMapping()
    public ResponseEntity<Iterable<ScheduledOrder>> getAll(){
        try{
            return new ResponseEntity<>(scheduledOrderService.GetAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path = "test-send")
    public ResponseEntity<Object> sendOrders(){
        try{
            scheduledOrderService.sendOrders();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
