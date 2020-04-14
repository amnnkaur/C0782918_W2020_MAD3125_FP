package com.example.c0782918_w2020_mad3125_fp.model;

public class Customer {

    private int customerID;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String birthDate;

    public Customer() {
    }

    public Customer(int customerID, String firstName, String lastName, String fullName, String email, String phoneNumber, String gender, String birthDate) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthDate = birthDate;
    }


}

