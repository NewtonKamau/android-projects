package com.creativeconsillium.drumsforafrica.kopo.Model;

public class ModelPaidLoans {

    private String paidAmount, paidNumber;
    private int paidProvider;

    public ModelPaidLoans(int paidProvider, String paidAmount, String paidNumber) {
        this.paidProvider = paidProvider;
        this.paidAmount = paidAmount;
        this.paidNumber = paidNumber;
    }

    public int getPaidProvider() { return paidProvider; }
    public void setPaidProvider(int paidProvider) {
        this.paidProvider = paidProvider;
    }

    public String getPaidAmount() { return paidAmount; }
    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaidNumber() { return paidNumber; }
    public void setPaidNumber(String paidNumber) {
        this.paidNumber = paidNumber;
    }


}
