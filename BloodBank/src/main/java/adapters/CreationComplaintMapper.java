package adapters;

import com.example.BloodBank.dto.complaintDTOs.CreationComplaintDTO;
import com.example.BloodBank.model.Complaint;
import com.example.BloodBank.model.ComplaintStatus;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

public class CreationComplaintMapper {
    private static ModelMapper modelMapper;

    public CreationComplaintMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static CreationComplaintDTO toCreationComplaintDTO(Complaint complaint){
        CreationComplaintDTO creationComplaintDTO = modelMapper.map(complaint, CreationComplaintDTO.class);
        return creationComplaintDTO;
    }

    public static Complaint fromCreationComplaintDTO(CreationComplaintDTO creationComplaintDTO){
        Complaint complaint = modelMapper.map(creationComplaintDTO, Complaint.class);
        complaint.setSubmissionDate(LocalDate.now());
        complaint.setComplaintStatus(ComplaintStatus.UNANSWERED);
        return complaint;
    }
}
