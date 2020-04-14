package com.example.c0782918_w2020_mad3125_fp.model;

import java.util.Date;

public class Internet extends Bill {

    private String providerName;
    private String internetGBUsed;

    public Internet(String billID, BillType billType, Date billDate, Double billTotal, String providerName, String internetGBUsed) {
        super(billID, billType, billDate, billTotal);

        this.providerName = providerName;
        this.internetGBUsed = internetGBUsed;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getInternetGBUsed() {
        return internetGBUsed;
    }

    public void setInternetGBUsed(String internetGBUsed) {
        this.internetGBUsed = internetGBUsed;
    }
}
