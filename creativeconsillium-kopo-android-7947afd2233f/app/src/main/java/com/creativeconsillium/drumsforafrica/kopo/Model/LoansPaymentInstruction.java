package com.creativeconsillium.drumsforafrica.kopo.Model;

public class LoansPaymentInstruction {

    private String instNumber, instText;

    public LoansPaymentInstruction(String instNumber, String instText) {
        this.instNumber = instNumber;
        this.instText = instText;
    }

    public String getInstNumber() {
        return instNumber;
    }
    public void setInstNumber(String instNumber) {
        this.instNumber = instNumber;
    }

    public String getInstText() {
        return instText;
    }
    public void setInstText(String instText) {
        this.instText = instText;
    }


}
