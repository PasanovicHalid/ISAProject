package com.example.BloodBank.service;

import com.example.BloodBank.dto.ComplaintDTO;
import com.example.BloodBank.model.*;
import com.example.BloodBank.repository.ComplaintRepository;
import com.example.BloodBank.service.service_interface.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintService implements IComplaintService {
    private final ComplaintRepository complaintRepository;
    private final CustomerService customerService;
    private final BloodBankService bloodBankService;
    private final AdminService adminService;
    @Autowired
    public ComplaintService(ComplaintRepository complaintRepository,CustomerService customerService,
                            BloodBankService bloodBankService, AdminService adminService) {
        this.complaintRepository = complaintRepository;
        this.customerService = customerService;
        this.bloodBankService = bloodBankService;
        this.adminService = adminService;
    }

    @Override
    public Complaint Create(Complaint entity) throws Exception {
        entity.setCustomer(customerService.FindByUsername(entity.getCustomer().getUsername()));
        return complaintRepository.save(entity);
    }

    @Override
    public Complaint Read(Long id) throws Exception {
        return null;
    }

    @Override
    public Complaint Update(Complaint entity) throws Exception {
        return null;
    }

    @Override
    public void Delete(Complaint entity) throws Exception {

    }

    @Override
    public Iterable<Complaint> GetAll() throws Exception {
        return null;
    }

    @Override
    public List<Complaint> findAllByComplaintStatus(Pageable page) {
        Page<Complaint> pageComplaints =  complaintRepository.findAllByComplaintStatus(ComplaintStatus.UNANSWERED, page);
        List<Complaint> complaints = new ArrayList<>();
        for (Complaint c : pageComplaints) {
            complaints.add(c);
        }
        return complaints;
    }

    @Override
    public int getUnansweredComplaintsAmount() {
        List<Complaint> complaints = complaintRepository.getComplaintsByComplaintStatusAmount(ComplaintStatus.UNANSWERED);
        return complaints.size();

    }

    @Override
    public List<ComplaintDTO> GetNecessaryInfo(List<ComplaintDTO> complaintDTOS, List<Complaint> complaints) {
        for(ComplaintDTO c : complaintDTOS){
            Complaint realComplaint = complaints.get(complaintDTOS.indexOf(c));
            c.setCustomerName(realComplaint.getCustomer().getFirstName() + " " +
                    realComplaint.getCustomer().getLastName());

            if(realComplaint.getComplaintType().equals(ComplaintType.FACILITY))
                c.setDefendantName(bloodBankService.findByEmail(realComplaint.getEmailOfDefendant()).get().getName());
            else{
                Admin admin = adminService.findByEmail(realComplaint.getEmailOfDefendant()).get();
                c.setDefendantName(admin.getFirstName() + " " + admin.getLastName());
            }
        }
        return  complaintDTOS;
    }

}
