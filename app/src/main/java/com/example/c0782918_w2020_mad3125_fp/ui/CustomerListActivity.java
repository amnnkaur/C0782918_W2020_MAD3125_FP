package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.c0782918_w2020_mad3125_fp.DataBinderMapperImpl;
import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityCustomerListBinding;

public class CustomerListActivity extends AppCompatActivity {

    ActivityCustomerListBinding customerListBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customerListBinding = DataBindingUtil.setContentView(this, R.layout.activity_customer_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_customer,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_aboutUs:
                /*Intent abtIntent = new Intent(CustomerListActivity.this,AddNewCustomerActivity.class);
                startActivity(abtIntent);*/
                break;
            case R.id.menu_contactUs:
               /* Intent conIntent = new Intent(CustomerListActivity.this,LoginActivity.class);
                startActivity(conIntent);*/
                break;
            case R.id.menu_logout:
                
        }
        return super.onOptionsItemSelected(item);
    }
}
