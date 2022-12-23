package adapters;

import com.example.BloodBank.dto.userDTOs.UserDTO;
import com.example.BloodBank.model.User;
import org.modelmapper.ModelMapper;

public class UserMapper {
    private static ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    public static User fromDTO(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }
}
