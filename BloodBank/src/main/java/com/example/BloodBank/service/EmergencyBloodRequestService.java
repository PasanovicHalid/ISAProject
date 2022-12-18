package com.example.BloodBank.service;

import com.example.BloodBank.model.BloodBank;
import com.example.BloodBank.repository.CustomerRepository;
import com.example.BloodBank.service.service_interface.IBloodBankService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import proto.emergencyBloodRequests.CheckRequest;
import proto.emergencyBloodRequests.CheckResponse;
import proto.emergencyBloodRequests.EmergencyRequest;
import proto.emergencyBloodRequests.EmergencyResponse;

import java.util.List;

@GrpcService
public class EmergencyBloodRequestService extends proto.emergencyBloodRequests.EmergencyRequestGrpcServiceGrpc.EmergencyRequestGrpcServiceImplBase {

    private final IBloodBankService bloodBankService;

    @Autowired
    public EmergencyBloodRequestService(IBloodBankService bloodBankService) {
        this.bloodBankService = bloodBankService;
    }

    @Override
    public void requestBlood(EmergencyRequest request, StreamObserver<EmergencyResponse> responseObserver) {
        try
        {
            List<BloodBank> bankList = bloodBankService.getAll();
            for (BloodBank bank: bankList)
            {
                if(ChangeBloodCount(bank, request.getRequest()))
                {
                    bloodBankService.Update(bank);
                    EmergencyResponse response = EmergencyResponse.newBuilder().setRequest(request.getRequest()).setStatus(proto.emergencyBloodRequests.SendStatus.SENT).build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            }
        } catch (Exception e) {
            EmergencyResponse response = EmergencyResponse.newBuilder().setRequest(request.getRequest()).setStatus(proto.emergencyBloodRequests.SendStatus.DENIED).build();
            responseObserver.onNext(response);
            responseObserver.onError(e);
        }
    }

    @Override
    public void checkIfBloodIsAvailable(CheckRequest request, StreamObserver<CheckResponse> responseObserver) {
        try
        {
            List<BloodBank> bankList = bloodBankService.getAll();
            for (BloodBank bank: bankList)
            {
                if(ChangeBloodCount(bank, request))
                {
                    CheckResponse response = CheckResponse.newBuilder().setRequest(request).setAvailability(proto.emergencyBloodRequests.BloodAvailability.AVAILABLE).build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    return;
                }
            }
            CheckResponse response = CheckResponse.newBuilder().setRequest(request).setAvailability(proto.emergencyBloodRequests.BloodAvailability.UNAVAILABLE).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            CheckResponse response = CheckResponse.newBuilder().setRequest(request).setAvailability(proto.emergencyBloodRequests.BloodAvailability.UNAVAILABLE).build();
            responseObserver.onNext(response);
            responseObserver.onError(e);
        }
    }

    private static boolean ChangeBloodCount(BloodBank bank, CheckRequest request){
        if(bank.getBlood() == null){
            return false;
        }
        switch (request.getBloodType()){
            case AN:
                if(bank.getBlood().getAminus() >= request.getBloodQuantity()){
                    if(bank.getBlood().getAminus() - request.getBloodQuantity() < 0){
                        return false;
                    }
                    bank.getBlood().setAminus((int) (bank.getBlood().getAminus() - request.getBloodQuantity()));
                    return true;
                }
                return false;
            case AP:
                if(bank.getBlood().getAplus() >= request.getBloodQuantity()){
                    if(bank.getBlood().getAplus() - request.getBloodQuantity() < 0){
                        return false;
                    }
                    bank.getBlood().setAplus((int) (bank.getBlood().getAplus() - request.getBloodQuantity()));
                    return true;
                }
                return false;
            case BN:
                if(bank.getBlood().getBminus() >= request.getBloodQuantity()){
                    if(bank.getBlood().getBminus() - request.getBloodQuantity() < 0){
                        return false;
                    }
                    bank.getBlood().setBminus((int) (bank.getBlood().getBminus() - request.getBloodQuantity()));
                    return true;
                }
                return false;
            case BP:
                if(bank.getBlood().getBplus() >= request.getBloodQuantity()){
                    if(bank.getBlood().getBplus() - request.getBloodQuantity() < 0){
                        return false;
                    }
                    bank.getBlood().setBplus((int) (bank.getBlood().getBplus() - request.getBloodQuantity()));
                    return true;
                }
                return false;
            case ON:
                if(bank.getBlood().getOminus() >= request.getBloodQuantity()){
                    if(bank.getBlood().getOminus() - request.getBloodQuantity() < 0){
                        return false;
                    }
                    bank.getBlood().setOminus((int) (bank.getBlood().getOminus() - request.getBloodQuantity()));
                    return true;
                }
                return false;
            case OP:
                if(bank.getBlood().getOplus() >= request.getBloodQuantity()){
                    if(bank.getBlood().getOplus() - request.getBloodQuantity() < 0){
                        return false;
                    }
                    bank.getBlood().setOplus((int) (bank.getBlood().getOplus() - request.getBloodQuantity()));
                    return true;
                }
                return false;
            case ABN:
                if(bank.getBlood().getABminus() >= request.getBloodQuantity()){
                    if(bank.getBlood().getABminus() - request.getBloodQuantity() < 0){
                        return false;
                    }
                    bank.getBlood().setABminus((int) (bank.getBlood().getABminus() - request.getBloodQuantity()));
                    return true;
                }
                return false;
            case ABP:
                if(bank.getBlood().getABplus() >= request.getBloodQuantity()){
                    if(bank.getBlood().getABplus() - request.getBloodQuantity() < 0){
                        return false;
                    }
                    bank.getBlood().setABplus((int) (bank.getBlood().getABplus() - request.getBloodQuantity()));
                    return true;
                }
                return false;
            default:
                return false;
        }
    }
}