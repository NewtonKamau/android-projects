package com.creativeconsillium.drumsforafrica.kopo.Model;

public class LoanProvider {

    private String title;
    private int providerImg, tickImg;

    public LoanProvider(String title, int providerImg, int tickImg) {
        this.title = title;
        this.providerImg = providerImg;
        this.tickImg = tickImg;
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

    public int getTickImg() { return tickImg; }
    public void setTickImg(int tickImg) {
        this.tickImg = tickImg;
    }


}
