package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.NotActivatedUser;

public interface INotActivatedUserService extends  ICRUDService<NotActivatedUser> {
    public NotActivatedUser ReadByActivationCode(String code) throws Exception;
    public Boolean Activate(String activationCode) throws Exception;
}
