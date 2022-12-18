package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.Complaint;
import com.example.BloodBank.model.ComplaintStatus;
import com.example.BloodBank.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IComplaintService extends ICRUDService<Complaint>{
    List<Complaint> findAllByComplaintStatus(Pageable page);
    int getUnansweredComplaintsAmount();
}
