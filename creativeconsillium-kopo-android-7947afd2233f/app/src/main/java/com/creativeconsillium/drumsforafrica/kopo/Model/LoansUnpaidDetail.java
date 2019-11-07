package com.creativeconsillium.drumsforafrica.kopo.Model;

public class LoansUnpaidDetail {

    private String unpaidDue, unpaidAmount, unpaidBorrowed, unpaidInterest;

    public LoansUnpaidDetail(String unpaidDue, String unpaidAmount, String unpaidBorrowed, String unpaidInterest) {
        this.unpaidDue = unpaidDue;
        this.unpaidAmount = unpaidAmount;
        this.unpaidBorrowed = unpaidBorrowed;
        this.unpaidInterest = unpaidInterest;
    }

    public String getPaidDue() {
        return unpaidDue;
    }
    public void setPaidDue(String unpaidDue) {
        this.unpaidDue = unpaidDue;
    }

    public String getPaidAmount() {
        return unpaidAmount;
    }
    public void setPaidAmount(String unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    public String getPaidBorrowed() { return unpaidBorrowed; }
    public void setPaidBorrowed(String unpaidBorrowed) {
        this.unpaidBorrowed = unpaidBorrowed;
    }

    public String getPaidInterest() {
        return unpaidInterest;
    }
    public void setPaidInterest(String unpaidInterest) {
        this.unpaidInterest = unpaidInterest;
    }


}
