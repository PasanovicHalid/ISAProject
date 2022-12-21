package adapters;

import com.example.BloodBank.dto.AppointmentDTO;
import com.example.BloodBank.dto.AppointmentViewDTO;
import com.example.BloodBank.dto.BloodBankAppointmentViewDTO;
import com.example.BloodBank.dto.CalendarAppointmentDTO;
import com.example.BloodBank.model.Appointment;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarAppointmentMapper {
    private static ModelMapper modelMapper;

    public CalendarAppointmentMapper(ModelMapper mapper) {
        this.modelMapper = mapper;
    }

    public static CalendarAppointmentDTO toCalendarAppointmentDTO(Appointment appointment){

        CalendarAppointmentDTO app =  modelMapper.map(appointment, CalendarAppointmentDTO.class);
        app.setStart(LocalDateTime.of(toLocalDate(appointment.getAppointmentDate()),toLocalTime(appointment.getStartTime())));
        app.setEnd(LocalDateTime.of(toLocalDate(appointment.getAppointmentDate()),toLocalTime(appointment.getEndTime())));

        String customerName = appointment.getTakenBy().getFirstName() + " " + appointment.getTakenBy().getLastName();
        int startHour = app.getStart().getHour();
        int startMinute = app.getStart().getMinute();
        int endHour = app.getEnd().getHour();
        int endMinute = app.getEnd().getMinute();

        customerName += " -> " + startHour + ":";
        if(startMinute < 10)
            customerName += "0" + startMinute;
        else
            customerName += startMinute;

        customerName += " - " + endHour + ":";

        if(endMinute < 10)
            customerName += "0" + endMinute;
        else
            customerName += endMinute;

        app.setTitle(customerName);
        return app;
    }

    public static Appointment fromCalendarAppointmentDTO(CalendarAppointmentDTO calendarAppointmentDTO){
        return modelMapper.map(calendarAppointmentDTO, Appointment.class);
    }

    public static List<CalendarAppointmentDTO> toCalendarAppointmentDTOList(List<Appointment> appointments){

        List<CalendarAppointmentDTO> appointmentDTOS = new ArrayList<>();
        for (Appointment a: appointments) {
            appointmentDTOS.add(toCalendarAppointmentDTO(a));
        }
        return appointmentDTOS;
    }
    public static LocalDate toLocalDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public static LocalTime toLocalTime(java.sql.Time time) {
        return time.toLocalTime();
    }
}
