package com.example.c0782918_w2020_mad3125_fp.singleton;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.model.BillType;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.model.Internet;
import com.example.c0782918_w2020_mad3125_fp.model.Mobile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class DataStorage {
    static private DataStorage instance = new DataStorage();
    private ArrayList<Customer> customerArrayList = new ArrayList<>();
    private ArrayList<Hydro> hydroArrayList = new ArrayList<>();
    private ArrayList<Mobile> mobileArrayList = new ArrayList<>();
    private ArrayList<Internet> internetArrayList = new ArrayList<>();

    public DataStorage() {
    }
    static public DataStorage getInstance(){
        return instance;
    }
    public void addCustomer(Customer customer){
        this.customerArrayList.add(customer);
    }
    public void addHydro(Hydro hydro){
        this.hydroArrayList.add(hydro);
    }
    public void addInternet(Internet internet){
        this.internetArrayList.add(internet);
    }
    public void addMobile(Mobile mobile){
        this.mobileArrayList.add(mobile);
    }


    public ArrayList<Customer> getAllCustomers(){
        return this.customerArrayList;
    }
    public ArrayList<Hydro> getAllHydro(){
        return this.hydroArrayList;
    }
    public ArrayList<Mobile> getAllMobile(){
        return this.mobileArrayList;
    }
    public ArrayList<Internet> getAllInternet(){
        return this.internetArrayList;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void loadData(){
        this.customerArrayList.add(new Customer(1, R.drawable.male,"Aman","Chhabra","aman@gmail.com","876551558"));
        this.customerArrayList.add(new Customer(2, R.drawable.male,"Anmol","Singh","anmol@gmail.com","8792158622"));
        this.customerArrayList.add(new Customer(3, R.drawable.male,"Monika","Sharma","monika@gmail.com","8765448"));
        this.customerArrayList.add(new Customer(4, R.drawable.male,"Roop","Kaur","roop@gmail.com","86565655768"));
        this.customerArrayList.add(new Customer(5, R.drawable.male,"Jas","Kaur","jas@gmail.com","866526768"));
        this.customerArrayList.add(new Customer(6, R.drawable.male,"Kritima","Kukreja","kritima@gmail.com","854546768"));
        this.customerArrayList.add(new Customer(7, R.drawable.male,"Harpreet","Singh","harpreet@gmail.com","8755456468"));

        Hydro hyd1 = new Hydro("HYD1",BillType.HYDRO,Date.from(Instant.now()),40.25,"qwerty",20);
        this.hydroArrayList.add(hyd1);

    }
}
