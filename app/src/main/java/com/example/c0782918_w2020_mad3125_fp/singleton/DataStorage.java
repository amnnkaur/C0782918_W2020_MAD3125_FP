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
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DataStorage {
    static private DataStorage instance = new DataStorage();
    private HashMap<String, Customer> customerHashMap = new HashMap<>();
    private ArrayList<Customer> customerArrayList;
    static private ArrayList<Hydro> hydroArrayList = new ArrayList<>();
    static private ArrayList<Mobile> mobileArrayList = new ArrayList<>();
    static private ArrayList<Internet> internetArrayList = new ArrayList<>();

    public DataStorage() {
    }
    static public DataStorage getInstance(){
        return instance;
    }
    public void addCustomer(String customerId, Customer customer1){
        this.customerHashMap.put(customerId,customer1);
    }
    public void addHydro(Hydro hydro){
        this.hydroArrayList.add(0, hydro);
    }
    public void addInternet(Internet internet){
        this.internetArrayList.add(0,internet);
    }
    public void addMobile(Mobile mobile){
        this.mobileArrayList.add(0,mobile);
    }

    public HashMap<String, Customer> getCustomerHashMap() {
        return customerHashMap;
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
       /* this.customerArrayList.add(new Customer("CUS01", R.drawable.male,"Aman","Chhabra","aman@gmail.com","876551558"));
        this.customerArrayList.add(new Customer("CUS02", R.drawable.male,"Anmol","Singh","anmol@gmail.com","8792158622"));
        this.customerArrayList.add(new Customer("CUS01", R.drawable.male,"Monika","Sharma","monika@gmail.com","8765448"));
        this.customerArrayList.add(new Customer("CUS01", R.drawable.male,"Roop","Kaur","roop@gmail.com","86565655768"));
        this.customerArrayList.add(new Customer("CUS01", R.drawable.male,"Jas","Kaur","jas@gmail.com","866526768"));
        this.customerArrayList.add(new Customer("CUS01", R.drawable.male,"Kritima","Kukreja","kritima@gmail.com","854546768"));
        this.customerArrayList.add(new Customer("CUS01", R.drawable.male,"Harpreet","Singh","harpreet@gmail.com","8755456468"));
*/
        Customer cus1 = new Customer("CUS01",R.drawable.male,"Aman","Kaur","aman@gmail.com","134566");
        Customer cus2 = new Customer("CUS02", R.drawable.male,"Anmol","Singh","anmol@gmail.com","8792158622");
        Customer cus3 = new Customer("CUS03", R.drawable.male,"Monika","Sharma","monika@gmail.com","8765448");
        Customer cus4 = new Customer("CUS04",R.drawable.male,"Roop","Kaur","roop@gmail.com","86565655768");
//        Customer cus5 = new Customer("CUS05",R.drawable.male,"Jas","Kaur","jas@gmail.com","866526768");
//        Customer cus6 = new Customer("CUS06",R.drawable.male,"Harpreet","Singh","harpreet@gmail.com","8755456468");

        Hydro hyd1 = new Hydro("CUS01","HYD1",BillType.HYDRO,"18/04/2020","Electricity Services",20);
        Hydro hyd2 = new Hydro("CUS02","HYD2",BillType.HYDRO,"18/04/2020","Electricity Services",10);
        Hydro hyd3 = new Hydro("CUS01","HYD3",BillType.HYDRO,"18/04/2020","Electricity Services",50);
        Hydro hyd4 = new Hydro("CUS02","HYD4",BillType.HYDRO,"18/04/2020","Electricity Services",50);
        Hydro hyd5 = new Hydro("CUS01","HYD5",BillType.HYDRO,"18/04/2020","Electricity Services",50);
        Hydro hyd6 = new Hydro("CUS02","HYD6",BillType.HYDRO,"18/04/2020","Electricity Services",50);
        Hydro hyd7 = new Hydro("CUS03","HYD7",BillType.HYDRO,"18/04/2020","Electricity Services",50);
        Hydro hyd8 = new Hydro("CUS03","HYD8",BillType.HYDRO,"18/04/2020","Electricity Services",50);
        Hydro hyd9 = new Hydro("CUS03","HYD9",BillType.HYDRO,"18/04/2020","Electricity Services",50);
        Hydro hyd10 = new Hydro("CUS04","HYD10",BillType.HYDRO,"18/04/2020","Electricity Services",50);
        Hydro hyd11 = new Hydro("CUS04","HYD11",BillType.HYDRO,"18/04/2020","Electricity Services",50);
        Hydro hyd12 = new Hydro("CUS04","HYD12",BillType.HYDRO,"18/04/2020","Electricity Services",50);

//        Hydro hyd7 = new Hydro("CUS02","HYD7",BillType.HYDRO,"18/04/2020","qwerty",50);
        this.hydroArrayList.add(hyd1);
        this.hydroArrayList.add(hyd2);
        this.hydroArrayList.add(hyd3);
        this.hydroArrayList.add(hyd4);
        this.hydroArrayList.add(hyd5);
        this.hydroArrayList.add(hyd6);
        this.hydroArrayList.add(hyd7);
        this.hydroArrayList.add(hyd8);
        this.hydroArrayList.add(hyd9);
        this.hydroArrayList.add(hyd10);
        this.hydroArrayList.add(hyd11);
        this.hydroArrayList.add(hyd12);
//        this.hydroArrayList.add(hyd7);

        Mobile mob1 = new Mobile("CUS01","MOB1",BillType.MOBILE,"18/04/2020","Apple","Freedom","54577678",10,40);
        Mobile mob2 = new Mobile("CUS01","MOB2",BillType.MOBILE,"18/04/2020","Samsung","Lucky","3532523",20,40);
        Mobile mob3 = new Mobile("CUS01","MOB3",BillType.MOBILE,"18/04/2020","Lenovo","Fido","325255252",30,40);
        Mobile mob4 = new Mobile("CUS02","MOB4",BillType.MOBILE,"18/04/2020","Apple","Freedom","54577678",10,40);
        Mobile mob5 = new Mobile("CUS02","MOB5",BillType.MOBILE,"18/04/2020","Samsung","Lucky","3532523",20,40);
        Mobile mob6 = new Mobile("CUS02","MOB6",BillType.MOBILE,"18/04/2020","Lenovo","Fido","325255252",30,40);
        Mobile mob7 = new Mobile("CUS03","MOB7",BillType.MOBILE,"18/04/2020","Apple","Freedom","54577678",10,40);
        Mobile mob8 = new Mobile("CUS03","MOB8",BillType.MOBILE,"18/04/2020","Samsung","Lucky","3532523",20,40);
        Mobile mob9 = new Mobile("CUS03","MOB9",BillType.MOBILE,"18/04/2020","Lenovo","Fido","325255252",30,40);
        Mobile mob10 = new Mobile("CUS04","MOB10",BillType.MOBILE,"18/04/2020","Apple","Freedom","54577678",10,40);
        Mobile mob11 = new Mobile("CUS04","MOB11",BillType.MOBILE,"18/04/2020","Samsung","Lucky","3532523",20,40);
        Mobile mob12 = new Mobile("CUS04","MOB12",BillType.MOBILE,"18/04/2020","Lenovo","Fido","325255252",30,40);

        this.mobileArrayList.add(mob1);
        this.mobileArrayList.add(mob2);
        this.mobileArrayList.add(mob3);
        this.mobileArrayList.add(mob4);
        this.mobileArrayList.add(mob5);
        this.mobileArrayList.add(mob6);
        this.mobileArrayList.add(mob7);
        this.mobileArrayList.add(mob8);
        this.mobileArrayList.add(mob9);
        this.mobileArrayList.add(mob10);
        this.mobileArrayList.add(mob11);
        this.mobileArrayList.add(mob12);

        Internet int1 = new Internet("CUS01","INT1",BillType.INTERNET,"18/04/2020","Freedom",50);
        Internet int2 = new Internet("CUS01","INT2",BillType.INTERNET,"18/04/2020","Lucky",50);
        Internet int3 = new Internet("CUS01","INT3",BillType.INTERNET,"18/04/2020","Fido",50);
        Internet int4 = new Internet("CUS02","INT4",BillType.INTERNET,"18/04/2020","Freedom",50);
        Internet int5 = new Internet("CUS02","INT5",BillType.INTERNET,"18/04/2020","Lucky",50);
        Internet int6 = new Internet("CUS02","INT6",BillType.INTERNET,"18/04/2020","Fido",50);
        Internet int7 = new Internet("CUS03","INT7",BillType.INTERNET,"18/04/2020","Freedom",50);
        Internet int8 = new Internet("CUS03","INT8",BillType.INTERNET,"18/04/2020","Lucky",50);
        Internet int9 = new Internet("CUS03","INT9",BillType.INTERNET,"18/04/2020","Fido",50);
        Internet int10 = new Internet("CUS04","INT10",BillType.INTERNET,"18/04/2020","Freedom",50);
        Internet int11 = new Internet("CUS04","INT11",BillType.INTERNET,"18/04/2020","Lucky",50);
        Internet int12 = new Internet("CUS04","INT12",BillType.INTERNET,"18/04/2020","Fido",50);

        this.internetArrayList.add(int1);
        this.internetArrayList.add(int2);
        this.internetArrayList.add(int3);
        this.internetArrayList.add(int4);
        this.internetArrayList.add(int5);
        this.internetArrayList.add(int6);
        this.internetArrayList.add(int7);
        this.internetArrayList.add(int8);
        this.internetArrayList.add(int9);
        this.internetArrayList.add(int10);
        this.internetArrayList.add(int11);
        this.internetArrayList.add(int12);

//
//        cus1.addBillToCustomer(hyd1);
//        cus1.addBillToCustomer(mob1);
//        cus2.addBillToCustomer(int1);
//        cus3.addBillToCustomer(mob2);
//        cus3.addBillToCustomer(int2);
//        cus4.addBillToCustomer(hyd2);
//        cus4.addBillToCustomer(mob3);
//        cus2.addBillToCustomer(mob1);
//        cus5.addBillToCustomer(hyd3);
//        cus5.addBillToCustomer(int3);
//        cus6.addBillToCustomer(hyd3);
//        cus6.addBillToCustomer(int1);

        customerHashMap.put(cus1.getCustomerID(),cus1);
        customerHashMap.put(cus2.getCustomerID(),cus2);
        customerHashMap.put(cus3.getCustomerID(),cus3);
        customerHashMap.put(cus4.getCustomerID(),cus4);
//        customerHashMap.put(cus5.getCustomerID(),cus5);
//        customerHashMap.put(cus6.getCustomerID(),cus6);

        Collection<Customer> values = customerHashMap.values();
        this.customerArrayList = new ArrayList<>(values);

    }
}
