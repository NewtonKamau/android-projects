package com.creativeconsillium.drumsforafrica.kopo.Model;

public class ReportProvider {

    private String provNumber, provAmount, provLoans, provInterest;
    private int provImg;

    public ReportProvider(String provNumber, String provAmount, String provLoans, String provInterest, int provImg) {
        this.provNumber = provNumber;
        this.provAmount = provAmount;
        this.provLoans = provLoans;
        this.provInterest = provInterest;
        this.provImg = provImg;
    }

    public String getProvNumber() {
        return provNumber;
    }
    public void setProvNumber(String provNumber) {
        this.provNumber = provNumber;
    }

    public String getProvAmount() { return provAmount; }
    public void setProvAmount(String provAmount) {
        this.provAmount = provAmount;
    }

    public String getProvLoans() { return provLoans; }
    public void setProvLoans(String provLoans) {
        this.provLoans = provLoans;
    }

    public String getProvInterest() {
        return provInterest;
    }
    public void setProvInterest(String provInterest) {
        this.provInterest = provInterest;
    }

    public int getProvImg() { return provImg; }
    public void setProvImg(int provImg) {
        this.provImg = provImg;
    }


}
