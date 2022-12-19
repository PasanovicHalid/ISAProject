package adapters;

import com.example.BloodBank.dto.ComplaintDTO;
import com.example.BloodBank.dto.CreationComplaintDTO;
import com.example.BloodBank.dto.ViewUserDTO;
import com.example.BloodBank.model.Complaint;
import com.example.BloodBank.model.ComplaintStatus;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ComplaintMapper {
    private static ModelMapper modelMapper;

    public ComplaintMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public static ComplaintDTO toDTO(Complaint complaint){
        ComplaintDTO complaintDTO = modelMapper.map(complaint, ComplaintDTO.class);
        String type = complaintDTO.getComplaintType();
        complaintDTO.setComplaintType(type.substring(0, 1) + type.substring(1).toLowerCase());
        return complaintDTO;
    }

    public static Complaint fromDTO(ComplaintDTO complaintDTO){
        complaintDTO.setComplaintType(complaintDTO.getComplaintType().toUpperCase());
        Complaint complaint = modelMapper.map(complaintDTO, Complaint.class);
        System.out.println(complaint);
        return complaint;
    }

    public static List<ComplaintDTO> toDTOList(List<Complaint> complaints){
        try{
            ArrayList<ComplaintDTO> complaintsDTO = modelMapper.map(complaints, new TypeToken<List<ComplaintDTO>>() {}.getType());
            for(ComplaintDTO complaintDTO : complaintsDTO){
                String type = complaintDTO.getComplaintType();
                complaintDTO.setComplaintType(type.substring(0, 1) + type.substring(1).toLowerCase());
            }
            System.out.println(complaintsDTO);
            return complaintsDTO;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
//    ArrayList<ComplaintDTO> complaintsDTO = new ArrayList<ComplaintDTO>();
//            for(Complaint complaint : complaints){
//                    ComplaintDTO complaintDTO = toDTO(complaint);
//                    complaintDTO.setCustomerName(complaint.getCustomer().getFirstName() + " " + complaint.getCustomer().getLastName());
//                    if(complaint.getComplaintType().equals(ComplaintType.FACILITY))
//                    complaintDTO.setDefendantName(bloodBankService.findByEmail(complaint.getEmailOfDefendant()).get().getName());
//                    else{
//                    Customer c = customerService.findByEmail(complaint.getEmailOfDefendant()).get();
//                    complaintDTO.setDefendantName(c.getFirstName() + " " + c.getLastName());
//                    }
//
//                    System.out.println(complaintDTO);
//                    complaintsDTO.add(complaintDTO);
//                    }