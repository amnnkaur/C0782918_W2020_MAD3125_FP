package com.example.c0782918_w2020_mad3125_fp.model;

import java.util.Date;

public class Internet extends Bill {

    private String providerName;
    private int internetGBUsed;

    public Internet(String customerId,String billID, BillType billType, String billDate, String providerName, int internetGBUsed) {
        super(customerId,billID, billType, billDate);

        this.providerName = providerName;
        this.internetGBUsed = internetGBUsed;
        this.billTotal = getBillTotal();
    }


    @Override
    public Double getBillTotal() {
        double billAmount = 0.0;

        billAmount = 5.0 * this.internetGBUsed;

        return billAmount;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public int getInternetGBUsed() {
        return internetGBUsed;
    }

    public void setInternetGBUsed(int internetGBUsed) {
        this.internetGBUsed = internetGBUsed;
    }
}
