package com.example.c0782918_w2020_mad3125_fp.model;

import java.util.Date;

public class Mobile extends Bill {

    private String mobileManfName;
    private String planName;
    private String mobileNumber;
    private int internetUsed;
    private int minuteUsed;

    public Mobile(String customerId,String billID, BillType billType, String billDate, String mobileManfName, String planName, String mobileNumber, int internetUsed, int minuteUsed) {
        super(customerId,billID, billType, billDate);

        this.mobileManfName = mobileManfName;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.internetUsed = internetUsed;
        this.minuteUsed = minuteUsed;
        this.billTotal = getBillTotal();
    }

    @Override
    public Double getBillTotal() {
        double billTotal = 0.0;
        billTotal = 4.0 * (this.internetUsed) + 2.0 * (this.minuteUsed);
        return billTotal;
    }

    public String getMobileManfName() {
        return mobileManfName;
    }

    public void setMobileManfName(String mobileManfName) {
        this.mobileManfName = mobileManfName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getInternetUsed() {
        return internetUsed;
    }

    public void setInternetUsed(int internetUsed) {
        this.internetUsed = internetUsed;
    }

    public int getMinuteUsed() {
        return minuteUsed;
    }

    public void setMinuteUsed(int minuteUsed) {
        this.minuteUsed = minuteUsed;
    }
}
