package com.creativeconsillium.drumsforafrica.kopo.Model;

public class AccountLoanProviderModel {

    private String title, actionText;
    private int providerImg;

    public AccountLoanProviderModel(String title, int providerImg, String actionText) {
        this.title = title;
        this.providerImg = providerImg;
        this.actionText = actionText;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String name) {
        this.title = name;
    }

    public int getProviderImg() { return providerImg; }
    public void setProviderImg(int providerImg) {
        this.providerImg = providerImg;
    }

    public String getActionText() {
        return actionText;
    }
    public void setActionText(String actionText) {
        this.actionText = actionText;
    }


}
