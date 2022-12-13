package com.example.BloodBank.service;

import com.example.BloodBank.dto.BloodBankDTO;
import com.example.BloodBank.model.BloodBank;
import com.example.BloodBank.repository.AddressRepository;
import com.example.BloodBank.repository.BloodBankRepository;
import com.example.BloodBank.repository.BloodRepository;
import com.example.BloodBank.service.service_interface.IBloodBankService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;


@Service
public class BloodBankService implements IBloodBankService {
    private final BloodBankRepository bloodBankRepository;
    private final AddressRepository addressRepository;

    private final BloodRepository bloodRepository;
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    public BloodBankService(BloodBankRepository bloodBankRepository, AddressRepository addressRepository,BloodRepository bloodRepository) {
        this.bloodBankRepository = bloodBankRepository;
        this.addressRepository = addressRepository;
        this.bloodRepository = bloodRepository;
    }

    public boolean checkForBlood(String bankEmail, String bloodType, int quantity){

        for(BloodBank bank : bloodBankRepository.findAll()){
            if(bank.getEmail().equals(bankEmail)){
                switch (bloodType) {
                    case "Aplus":
                        if(bank.getBlood().getAplus() == 0)
                            return false;
                        return bank.getBlood().getAplus() >= quantity;
                    case "ABplus":
                        if(bank.getBlood().getABplus() == 0)
                            return false;
                        return bank.getBlood().getABplus() >= quantity;
                    case "Bplus":
                        if(bank.getBlood().getBplus() == 0)
                            return false;
                        return bank.getBlood().getBplus() >= quantity;
                    case "Oplus":
                        if(bank.getBlood().getOplus() == 0)
                            return false;
                        return bank.getBlood().getOplus() >= quantity;
                    case "Aminus":
                        if(bank.getBlood().getAminus() == 0)
                            return false;
                        return bank.getBlood().getAminus() >= quantity;
                    case "ABminus":
                        if(bank.getBlood().getABminus() == 0)
                            return false;
                        return bank.getBlood().getABminus() >= quantity;
                    case "Bminus":
                        if(bank.getBlood().getBminus() == 0)
                            return false;
                        return bank.getBlood().getBminus() >= quantity;
                    case "Ominus":
                        if(bank.getBlood().getOminus() == 0)
                            return false;
                        return bank.getBlood().getOminus() >= quantity;
                }
            }
        }
        return false;
    }

    public void checkAPIKey(String bankEmail, String APIKey) throws IllegalAccessException {

        Optional<BloodBank> bank = bloodBankRepository.findByEmail(bankEmail);
        if(!bank.isPresent())
            throw new IllegalStateException("Bank with that kind of email doesn't exist!");

        if(APIKey.equals("") || !APIKey.contains(bank.get().getAPIKey()))
            throw new IllegalAccessException("Authorization failed!");
    }

    @Transactional
    public void registerBloodBank(BloodBankDTO bloodBankDTO){
        BloodBank bloodBank = modelMapper.map(bloodBankDTO, BloodBank.class);
        try{
            bloodBankRepository.save(bloodBank);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Can't save bank!");
        }

    }

    @Override
    public List<BloodBank> getAll() throws Exception {
        try {
            return bloodBankRepository.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<BloodBank> getBanksByRatingRange(String filter, Pageable page) throws Exception {
        String[] numbers = filter.split("[|]");
        if(numbers.length != 2){
            throw new Exception("Error in filter string");
        }
        double temp = Double.parseDouble(numbers[0]);
        Page<BloodBank> bloodBankPage = bloodBankRepository.findByRatingRange(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]), page);
        List<BloodBank> bloodBanks = new ArrayList<>();
        for (BloodBank b: bloodBankPage) {
            bloodBanks.add(b);
        }
        return bloodBanks;
    }

    @Override
    public List<BloodBank> getBanksByName(String filter, Pageable page) throws Exception {
        Page<BloodBank> bloodBankPage = bloodBankRepository.findAllByName(filter.toLowerCase(), page);
        List<BloodBank> bloodBanks = new ArrayList<>();
        for (BloodBank b: bloodBankPage) {
            bloodBanks.add(b);
        }
        return bloodBanks;
    }

    @Override
    public List<BloodBank> getBanksByAddress(String filter, Pageable page) throws Exception {
        Page<BloodBank> bloodBankPage = bloodBankRepository.findByAddress(filter.toLowerCase(), page);
        List<BloodBank> bloodBanks = new ArrayList<>();
        for (BloodBank b: bloodBankPage) {
            bloodBanks.add(b);
        }
        return bloodBanks;
    }

    public Optional<BloodBank> findByEmail(String email) {
        if(!bloodBankRepository.findByEmail(email).isPresent())
            throw new IllegalStateException("Bank with that kind of email doesn't exist!");
        return bloodBankRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public Integer sendBlood(String bankEmail, String bloodType, int quantity) {
        if(checkForBlood(bankEmail, bloodType, quantity)){
            reduceBloodSupplies(bloodBankRepository.findByEmail(bankEmail).get(),bloodType, quantity);
            return quantity;
        }
        throw new UnsupportedOperationException("Can't send blood");
    }

    @Override
    public Boolean savePDF(String bankEmail, byte[] pdf) {
        LocalDateTime today = LocalDateTime.now();
        String filePath = new File("").getAbsolutePath();
        System.out.println(filePath);
        String formattedDate = today.format(DateTimeFormatter.ofPattern("ddMMyyyy_hhmm_"));
        try (FileOutputStream fos = new FileOutputStream(filePath + "/src/report_" + formattedDate + bankEmail +".pdf")) {
            fos.write(pdf);
            return true;
        }catch(Exception e){
            throw new UnsupportedOperationException(e.getMessage());
        }
    }

    @Transactional
    private void reduceBloodSupplies(BloodBank bank, String bloodType, int quantity){
        switch (bloodType) {
            case "Aplus":
                bank.getBlood().setAplus(bank.getBlood().getAplus() - quantity);
                break;
            case "ABplus":
                bank.getBlood().setABplus(bank.getBlood().getABplus() - quantity);
                break;
            case "Bplus":
                bank.getBlood().setBplus(bank.getBlood().getBplus() - quantity);
                break;
            case "Oplus":
                bank.getBlood().setOplus(bank.getBlood().getOplus() - quantity);
                break;
            case "Aminus":
                bank.getBlood().setAminus(bank.getBlood().getAminus() - quantity);
                break;
            case "ABminus":
                bank.getBlood().setABminus(bank.getBlood().getABminus() - quantity);
                break;
            case "Bminus":
                bank.getBlood().setBminus(bank.getBlood().getBminus() - quantity);
                break;
            case "Ominus":
                bank.getBlood().setOminus(bank.getBlood().getOminus() - quantity);
                break;
            default:
                throw new IllegalStateException("BloodType unrecognizable.");
        }
        bloodBankRepository.save(bank);
    }
    public List<BloodBankDTO> GetBanksAsDTO() throws Exception {
        List<BloodBankDTO> bankDTOS = modelMapper.map(bloodBankRepository.findAll(), new TypeToken<List<BloodBankDTO>>() {}.getType());
        return bankDTOS;
    }

    @Override
    public BloodBank Create(BloodBank entity) throws Exception {
        return null;
    }

    @Override
    public BloodBank Read(Long id) throws Exception {
        return null;
    }

    @Override
    public BloodBank Update(BloodBank entity) throws Exception {
        return null;
    }

    @Override
    public void Delete(BloodBank entity) throws Exception {

    }

    @Override
    public Iterable<BloodBank> GetAll() throws Exception {
        return null;
    }
}
