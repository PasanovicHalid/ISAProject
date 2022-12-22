package adapters;

import com.example.BloodBank.dto.appointmentDTOs.AppointmentCreationDTO;
import com.example.BloodBank.dto.appointmentDTOs.AppointmentDTO;
import com.example.BloodBank.dto.appointmentDTOs.AppointmentViewDTO;
import com.example.BloodBank.dto.appointmentDTOs.BloodBankAppointmentViewDTO;
import com.example.BloodBank.model.Appointment;
import com.example.BloodBank.model.AppointmentStatus;
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

    public static AppointmentViewDTO toAppointmentViewDTO(Appointment appointment){
        return new AppointmentViewDTO(appointment.getId(),
                appointment.getAppointmentDate(),
                appointment.getStartTime(),
                appointment.getEndTime(),
                new BloodBankAppointmentViewDTO(appointment.getLocation().getName(),
                        appointment.getLocation().getAddress().toString(),
                        appointment.getLocation().getRating()),appointment.getExecuted());
    }

    public static Appointment fromAppointmentDTO(AppointmentDTO appointmentDTO){
        return modelMapper.map(appointmentDTO, Appointment.class);
    }

    public static Appointment fromAppointmentCreationDTO(AppointmentCreationDTO appointmentDTO){
        return new Appointment(appointmentDTO.getDate(), appointmentDTO.getStart(), appointmentDTO.getEnd(), null, null, AppointmentStatus.FREE);
    }

    public static List<AppointmentDTO> toAppointmentDTOList(List<Appointment> appointments){
        return modelMapper.map(appointments, new TypeToken<List<AppointmentDTO>>() {}.getType());
    }

}
