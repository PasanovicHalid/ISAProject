package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.Appointment;
import com.example.BloodBank.model.HeadAdmin;

public interface IHeadAdminService extends ICRUDService<HeadAdmin>{
    void registerHeadAdmin(HeadAdmin headAdmin) throws Exception;
}
