package adapters;

import com.example.BloodBank.dto.AppointmentDTO;
import com.example.BloodBank.model.Appointment;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class AppointmentMapper {

    private static ModelMapper modelMapper;

    public AppointmentMapper(ModelMapper mapper) {
        this.modelMapper = mapper;
    }

    public static AppointmentDTO toAppointmentDTO(Appointment appointment){
        return modelMapper.map(appointment, AppointmentDTO.class);
    }

    public static Appointment fromAppointmentDTO(AppointmentDTO appointmentDTO){
        return modelMapper.map(appointmentDTO, Appointment.class);
    }

    public static List<AppointmentDTO> toAppointmentDTOList(List<Appointment> appointments){
        return modelMapper.map(appointments, new TypeToken<List<AppointmentDTO>>() {}.getType());
    }

}
