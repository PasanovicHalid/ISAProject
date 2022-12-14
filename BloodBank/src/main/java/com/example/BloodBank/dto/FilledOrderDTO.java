package com.example.BloodBank.dto;

import com.example.BloodBank.model.ScheduledOrder;

public class FilledOrderDTO {
    private Boolean isSent;
    private String bankEmail;
    private String bankApi;
    private String hospitalEmail;
    private int Aplus;
    private int Bplus;
    private int ABplus;
    private int Oplus;
    private int Aminus;
    private int Bminus;
    private int ABminus;
    private int Ominus;

    public void readScheduled(ScheduledOrder so){
        bankEmail = so.getBankEmail();
        hospitalEmail = so.getHospitalEmail();

        Aplus = so.getAplus();
        Bplus = so.getBplus();
        ABplus = so.getABplus();
        Oplus = so.getOplus();

        Aminus = so.getAminus();
        Bminus = so.getBminus();
        ABminus = so.getABminus();
        Ominus = so.getOminus();
    }

    public Boolean getSent() {
        return isSent;
    }

    public void setSent(Boolean sent) {
        isSent = sent;
    }

    public String getBankEmail() {
        return bankEmail;
    }

    public void setBankEmail(String bankEmail) {
        this.bankEmail = bankEmail;
    }

    public String getBankApi() {
        return bankApi;
    }

    public void setBankApi(String bankApi) {
        this.bankApi = bankApi;
    }

    public String getHospitalEmail() {
        return hospitalEmail;
    }

    public void setHospitalEmail(String hospitalEmail) {
        this.hospitalEmail = hospitalEmail;
    }

    public int getAplus() {
        return Aplus;
    }

    public void setAplus(int aplus) {
        Aplus = aplus;
    }

    public int getBplus() {
        return Bplus;
    }

    public void setBplus(int bplus) {
        Bplus = bplus;
    }

    public int getABplus() {
        return ABplus;
    }

    public void setABplus(int ABplus) {
        this.ABplus = ABplus;
    }

    public int getOplus() {
        return Oplus;
    }

    public void setOplus(int oplus) {
        Oplus = oplus;
    }

    public int getAminus() {
        return Aminus;
    }

    public void setAminus(int aminus) {
        Aminus = aminus;
    }

    public int getBminus() {
        return Bminus;
    }

    public void setBminus(int bminus) {
        Bminus = bminus;
    }

    public int getABminus() {
        return ABminus;
    }

    public void setABminus(int ABminus) {
        this.ABminus = ABminus;
    }

    public int getOminus() {
        return Ominus;
    }

    public void setOminus(int ominus) {
        Ominus = ominus;
    }

    @Override
    public String toString() {
        return "FilledOrderDTO{" +
                "isSent=" + isSent +
                ", bankEmail='" + bankEmail + '\'' +
                ", bankApi='" + bankApi + '\'' +
                ", hospitalEmail='" + hospitalEmail + '\'' +
                ", Aplus=" + Aplus +
                ", Bplus=" + Bplus +
                ", ABplus=" + ABplus +
                ", Oplus=" + Oplus +
                ", Aminus=" + Aminus +
                ", Bminus=" + Bminus +
                ", ABminus=" + ABminus +
                ", Ominus=" + Ominus +
                '}';
    }
}
