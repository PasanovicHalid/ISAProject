package adapters;

import com.example.BloodBank.dto.userDTOs.RegisterHeadAdminDTO;
import com.example.BloodBank.model.HeadAdmin;
import org.modelmapper.ModelMapper;

public class HeadAdminMapper {
    private static ModelMapper modelMapper;

    public HeadAdminMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static RegisterHeadAdminDTO toDTO(HeadAdmin headAdmin){
        RegisterHeadAdminDTO registerHeadAdminDTO = modelMapper.map(headAdmin, RegisterHeadAdminDTO.class);
        return registerHeadAdminDTO;
    }

    public static HeadAdmin fromDTO(RegisterHeadAdminDTO registerHeadAdminDTO){
        HeadAdmin headAdmin = modelMapper.map(registerHeadAdminDTO, HeadAdmin.class);
        return headAdmin;
    }

}
