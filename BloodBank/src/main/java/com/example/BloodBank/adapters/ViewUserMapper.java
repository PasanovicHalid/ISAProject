package com.example.BloodBank.adapters;

import com.example.BloodBank.dto.UserDTO;
import com.example.BloodBank.dto.ViewUserDTO;
import com.example.BloodBank.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class ViewUserMapper {
    private static ModelMapper modelMapper;

    public ViewUserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static List<ViewUserDTO> toDTO(List<User> users){
        try{
            List<ViewUserDTO> usersDTO = modelMapper.map(users, new TypeToken<List<ViewUserDTO>>() {}.getType());
            return usersDTO;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
