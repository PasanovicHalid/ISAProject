package adapters;

import com.example.BloodBank.dto.userDTOs.ViewUserDTO;
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
            for(ViewUserDTO user : usersDTO){
                String role = user.getRole();
                user.setRole(role.substring(0, 1) + role.substring(1).toLowerCase());
                String gender = user.getGender();
                user.setGender(gender.substring(0, 1) + gender.substring(1).toLowerCase());
            }
            return usersDTO;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
