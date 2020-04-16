package com.example.c0782918_w2020_mad3125_fp.singleton;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;

public class DataStorage {
    static private DataStorage instance = new DataStorage();
    private ArrayList<Customer> customerArrayList = new ArrayList<>();
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
    public void loadData(){
        this.customerArrayList.add(new Customer(1, R.drawable.ic_launcher_foreground,"Aman","Chhabra","aman@gmail.com","8768",56.87));
    }
}
