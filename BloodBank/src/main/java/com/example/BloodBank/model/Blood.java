package com.example.BloodBank.model;

public class Blood {

    private double Aplus;
    private double Bplus;
    private double ABplus;
    private double Oplus;
    private double Aminus;
    private double Bminus;
    private double ABminus;
    private double Ominus;

    public Blood(double aplus, double bplus, double ABplus, double oplus,
                 double aminus, double bminus, double ABminus, double ominus) {
        Aplus = aplus;
        Bplus = bplus;
        this.ABplus = ABplus;
        Oplus = oplus;
        Aminus = aminus;
        Bminus = bminus;
        this.ABminus = ABminus;
        Ominus = ominus;
    }

    public double getAplus() {
        return Aplus;
    }

    public void setAplus(double aplus) {
        Aplus = aplus;
    }

    public double getBplus() {
        return Bplus;
    }

    public void setBplus(double bplus) {
        Bplus = bplus;
    }

    public double getABplus() {
        return ABplus;
    }

    public void setABplus(double ABplus) {
        this.ABplus = ABplus;
    }

    public double getOplus() {
        return Oplus;
    }

    public void setOplus(double oplus) {
        Oplus = oplus;
    }

    public double getAminus() {
        return Aminus;
    }

    public void setAminus(double aminus) {
        Aminus = aminus;
    }

    public double getBminus() {
        return Bminus;
    }

    public void setBminus(double bminus) {
        Bminus = bminus;
    }

    public double getABminus() {
        return ABminus;
    }

    public void setABminus(double ABminus) {
        this.ABminus = ABminus;
    }

    public double getOminus() {
        return Ominus;
    }

    public void setOminus(double ominus) {
        Ominus = ominus;
    }
}
