package com.example.BloodBank.service;

import com.example.BloodBank.dto.BookAppointmentDTO;
import com.example.BloodBank.model.Appointment;
import com.example.BloodBank.model.AppointmentStatus;
import com.example.BloodBank.model.Customer;
import com.example.BloodBank.repository.AppointmentRepository;
import com.example.BloodBank.repository.CustomerRepository;
import com.example.BloodBank.service.service_interface.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class AppointmentService implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;
    private final EmailSenderService emailSenderService;


    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              CustomerRepository customerRepository,
                              EmailSenderService emailSenderService) {
        this.appointmentRepository = appointmentRepository;
        this.customerRepository = customerRepository;
        this.emailSenderService = emailSenderService;
    }

    @Override
    @Transactional(readOnly = false)
    public Appointment Create(Appointment entity) throws Exception {
        return appointmentRepository.save(entity);
    }

    @Override
    public Appointment Read(Long id) throws Exception {
        return appointmentRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = false)
    public Appointment Update(Appointment entity) throws Exception {
        return appointmentRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void Delete(Appointment entity) throws Exception {
        appointmentRepository.delete(entity);
    }

    @Override
    public Iterable<Appointment> GetAll() throws Exception {
        return appointmentRepository.findAll();
    }

    public Page<Appointment> GetAllPageable(Pageable page) throws Exception {
        return appointmentRepository.findAll(page);
    }
    @Transactional(readOnly = false)
    public Appointment BookAppointment(BookAppointmentDTO dto) throws Exception {
        //check if appointment is free
        //check if customer filled questionnaire
        //check if customer donated blood in last 6 months

        //book appointment
        Appointment appointment = appointmentRepository.findById(dto.appointmentId).orElseThrow();
        appointment.setExecuted(AppointmentStatus.PENDING);
        appointment.setTakenBy(customerRepository.findById(dto.customerId).orElseThrow());
        String uuid = UUID.randomUUID().toString();
        appointment.setConfirmationCode(uuid);
        appointmentRepository.save(appointment);

        //send verification
        SendConfirmationCode(appointment);


        return appointment;
    }
    @Transactional(readOnly = false)
    public Appointment CancelAppointment(BookAppointmentDTO dto) throws Exception {
        Appointment appointment = appointmentRepository.findById(dto.appointmentId).get();
        Customer customer = customerRepository.findById(dto.customerId).get();

        //provera da li je za manje od 24h

        //provera da li je za appointment trenutno dodeljen ovaj korisnik
        if(appointment.getTakenBy().getId() != customer.getId()){
            return appointment;
        }
        //provera da li je booked ili pending
        if(appointment.getExecuted() != AppointmentStatus.BOOKED && appointment.getExecuted() != AppointmentStatus.PENDING){
            return appointment;
        }
        //namesti polja
        appointment.setExecuted(AppointmentStatus.FREE);
        appointment.setTakenBy(null);
        appointmentRepository.save(appointment);
        return appointment;

    }
    private void SendConfirmationCode(Appointment app){
        Customer customer = customerRepository.findById(app.getTakenBy().getId()).get();
        emailSenderService.sendSimpleEmail(customer.getEmail(), "Confirm booked appointment", "Appointment activation link is: http://localhost:8086/api/appointment/confirm/"+ app.getConfirmationCode());
    }
    @Transactional(readOnly = false)
    public Appointment ConfirmAppointment(String confirmationCode) throws Exception {
        try {
            Appointment app = appointmentRepository.findByConfirmationCode(confirmationCode).get();
            app.setExecuted(AppointmentStatus.BOOKED);
            appointmentRepository.save(app);
            return app;
        } catch (Exception ex) {
            throw new Exception("Error confirming booking");
        }
    }

}
