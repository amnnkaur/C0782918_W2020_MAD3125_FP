package com.example.c0782918_w2020_mad3125_fp.singleton;

import com.example.c0782918_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;

public class DataStorage {

    static private DataStorage instance;
    private ArrayList<Customer> customerArrayList;
    public DataStorage() {
    }
    static public DataStorage getInstance(){
        return instance;
    }
    public void addCustomer(Customer customer){
        this.customerArrayList.add(customer);
    }
    public ArrayList<Customer> getAllCustomers(){
        return this.customerArrayList;
    }
    /*public loadData()
    {
        customerArrayList.add(new Customer());

            }*/
}
