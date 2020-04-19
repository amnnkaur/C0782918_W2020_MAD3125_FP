package com.example.c0782918_w2020_mad3125_fp.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Bill implements Serializable {

    String customerId;
    String billID;
    BillType billType;
    String billDate;
    Double billTotal= 0.0;


    public Bill(String customerId, String billID, BillType billType, String billDate/*, Double billTotal*/) {
        this.customerId = customerId;
        this.billID = billID;
        this.billType = billType;
        this.billDate = billDate;
        // this.billTotal = billTotal;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }


    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public Double getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(Double billTotal) {
        this.billTotal = billTotal;
    }
}
