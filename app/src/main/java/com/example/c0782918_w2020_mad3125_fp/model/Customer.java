package com.example.c0782918_w2020_mad3125_fp.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Customer implements Serializable {
    private String customerID;
    private int customerImage;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String birthDate;
    private HashMap<String, Bill> billHashMap;
    private Double totalBill;


    public Customer(String customerID, int customerImage, String firstName, String lastName, String email, String phoneNumber) {
        this.customerID = customerID;
        this.customerImage = customerImage;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }
    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public int getCustomerImage() {
        return customerImage;
    }
    public void setCustomerImage(int customerImage) {
        this.customerImage = customerImage;
    }
    public Double getTotalBill() {
        return totalBill;
    }
    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFullName() {
        return (firstName + " " + lastName);
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public HashMap<String, Bill> getBillHashMap() {
        return billHashMap;
    }

    public void setBillHashMap(HashMap<String, Bill> billHashMap) {
        this.billHashMap = billHashMap;
    }

    public void addBillToCustomer(Bill billObj)
    {
        billHashMap = new HashMap<>();
        billHashMap.put(billObj.getBillID(),billObj);
    }

    public ArrayList<Bill> getAllBills()
    {
        Collection<Bill> values = billHashMap.values();
        ArrayList<Bill> billsList = new ArrayList<>(values);
        return billsList;
    }

    public double getTotalBillAmount()
    {
        double totalCalculatedBill = 0.0;
        for (Bill bill : billHashMap.values())
        {
            totalCalculatedBill += bill.billTotal;
        }
        return totalCalculatedBill;
    }
}
