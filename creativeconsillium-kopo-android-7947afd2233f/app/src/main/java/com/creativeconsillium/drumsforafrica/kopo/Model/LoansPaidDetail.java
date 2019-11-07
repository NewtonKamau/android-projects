package com.creativeconsillium.drumsforafrica.kopo.Model;

public class LoansPaidDetail {

    private String paidDate, paidAmount, paidBorrowed, paidInterest;

    public LoansPaidDetail(String paidDate, String paidAmount, String paidBorrowed, String paidInterest) {
        this.paidDate = paidDate;
        this.paidAmount = paidAmount;
        this.paidBorrowed = paidBorrowed;
        this.paidInterest = paidInterest;
    }

    public String getPaidDate() {
        return paidDate;
    }
    public void setPaidDate(String paidDate) { this.paidDate = paidDate; }

    public String getPaidAmount() {
        return paidAmount;
    }
    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaidBorrowed() { return paidBorrowed; }
    public void setPaidBorrowed(String paidBorrowed) {
        this.paidBorrowed = paidBorrowed;
    }

    public String getPaidInterest() {
        return paidInterest;
    }
    public void setPaidInterest(String paidInterest) {
        this.paidInterest = paidInterest;
    }


}
