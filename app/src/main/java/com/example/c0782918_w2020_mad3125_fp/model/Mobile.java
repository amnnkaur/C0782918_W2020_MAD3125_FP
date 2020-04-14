package com.example.c0782918_w2020_mad3125_fp.model;

import java.util.Date;

public class Mobile extends Bill {

    private String mobileManfName;
    private String planName;
    private String mobileNumber;
    private String internetUsed;
    private String minuteUsed;

    public Mobile(String billID, BillType billType, Date billDate, Double billTotal, String mobileManfName, String planName, String mobileNumber, String internetUsed, String minuteUsed) {
        super(billID, billType, billDate, billTotal);

        this.mobileManfName = mobileManfName;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.internetUsed = internetUsed;
        this.minuteUsed = minuteUsed;
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

    public String getInternetUsed() {
        return internetUsed;
    }

    public void setInternetUsed(String internetUsed) {
        this.internetUsed = internetUsed;
    }

    public String getMinuteUsed() {
        return minuteUsed;
    }

    public void setMinuteUsed(String minuteUsed) {
        this.minuteUsed = minuteUsed;
    }
}