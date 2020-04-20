package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;


import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.CustomerAdapter;
import com.example.c0782918_w2020_mad3125_fp.databinding.AboutUsBinding;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityCustomerListBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;

import java.util.ArrayList;

public class CustomerListActivity extends AppCompatActivity {

    ActivityCustomerListBinding customerListBinding;

    private CustomerAdapter customerAdapter;

    private ArrayList<Customer> customerArrayList;

    private WebView webView;
    private Dialog abtDialog, conDialog;
    TextView txtContactUs;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customerListBinding = DataBindingUtil.setContentView(this, R.layout.activity_customer_list);
        getSupportActionBar().setTitle("Customer List");

        customerListBinding.rvCustomerList.setLayoutManager(new LinearLayoutManager(this));
        customerListBinding.rvCustomerList.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        DataStorage.getInstance().loadData();
        populateCustomers();

        customerAdapter = new CustomerAdapter(customerArrayList);
        customerListBinding.rvCustomerList.setAdapter(customerAdapter);

        customerListBinding.fabAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fIntent = new Intent(CustomerListActivity.this,AddNewCustomerActivity.class);
                startActivity(fIntent);
            }
        });

        abtDialog = new Dialog(this);

    }
    public void populateCustomers(){
        customerArrayList = new ArrayList<>();

        if(DataStorage.getInstance().getAllCustomers().size() == 0){
            Toast.makeText(CustomerListActivity.this, "Null", Toast.LENGTH_SHORT).show();
        }else{
            customerArrayList = DataStorage.getInstance().getAllCustomers();}


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
                aboutUsDialog(webView);
                break;
            case R.id.menu_contactUs:
                contactUsDialog();
                break;
            case R.id.menu_logout:
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(CustomerListActivity.this);
                alertBuilder.setTitle("Logout");
                alertBuilder.setMessage("Are you sure you want to Logout?");
                alertBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent backIntent = new Intent(CustomerListActivity.this,LoginActivity.class);
                        startActivity(backIntent);
                    }

                });
                alertBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })

                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


        public void aboutUsDialog(View view){
            abtDialog = new Dialog(this);
            abtDialog.setContentView(R.layout.about_us);
            abtDialog.setTitle("About Us");
            webView = abtDialog.findViewById(R.id.web_abtUs);
            webView.loadUrl("https://www.lambtoncollege.ca/");
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return shouldOverrideUrlLoading(view,url);
                }
            });
            abtDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            abtDialog.show();
        }


    public void contactUsDialog(){
        conDialog = new Dialog(this);
        conDialog.setContentView(R.layout.contact_us);
        conDialog.setTitle("Contact Us");
        txtContactUs = findViewById(R.id.txtContactUs);
        conDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        conDialog.show();
    }


    @Override
    protected void onPause() {
        super.onPause();
        customerArrayList.clear();
    }
}
