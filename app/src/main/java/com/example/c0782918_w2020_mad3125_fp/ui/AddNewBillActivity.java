package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.model.Bill;
import com.example.c0782918_w2020_mad3125_fp.model.BillType;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.model.Internet;
import com.example.c0782918_w2020_mad3125_fp.model.Mobile;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;
import com.example.c0782918_w2020_mad3125_fp.util.StringUtil;

public class AddNewBillActivity extends AppCompatActivity {


    private TextView txtNewBillID;
    private TextView txtNewBillDate;
    private TextView txtNew1;
    private TextView txtNew2;
    private TextView txtNew3;
    private TextView txtNew4;
    private TextView txtNew5;
    private Spinner spinnerBillType;
    private Button billSaveButton;


    String[] billType = {"Hydro", "Internet", "Mobile"};

    Mobile mobile;
    Hydro hydro;
    Internet internet;
    ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_bill);
        txtNewBillID = findViewById(R.id.txtNewBillID);
        txtNewBillDate = findViewById(R.id.txtNewBillDate);
        txtNew1 = findViewById(R.id.txtNew1);
        txtNew2 = findViewById(R.id.txtNew2);
        txtNew3 = findViewById(R.id.txtNew3);
        txtNew4 = findViewById(R.id.txtNew4);
        txtNew5 = findViewById(R.id.txtNew5);
        spinnerBillType = findViewById(R.id.spinnerBillType);
        billSaveButton = findViewById(R.id.billSaveButton);

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, billType);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerBillType.setAdapter(spinnerAdapter);

        spinnerBillType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:
                        txtNew1.setHint("Enter Agency Name");
                        txtNew2.setHint("Units Consumed");
                        txtNew3.setVisibility(View.INVISIBLE);
                       txtNew4.setVisibility(View.INVISIBLE);
                        txtNew5.setVisibility(View.INVISIBLE);

                       billSaveButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (txtNewBillID.getText().toString().isEmpty()) {
                                    txtNewBillID.setError("Please enter Bill ID");
                                } else if (txtNewBillDate.getText().toString().isEmpty()) {
                                    txtNewBillDate.setError("Please select Bill Date");
                                } else if (txtNew1.getText().toString().isEmpty()) {
                                    txtNew1.setError("Please enter Agency Name");
                                } else if (txtNew2.getText().toString().isEmpty()) {
                                    txtNew2.setError("Please enter Units Consumed");
                                } else if (txtNewBillID.getText().toString().contains("HYD")) {

                                    Hydro hyd = new Hydro(txtNewBillID.getText().toString(),
                                            BillType.HYDRO,
                                            txtNewBillDate.getText().toString(),
                                            txtNew1.getText().toString(),
                                            Integer.parseInt(txtNew2.getText().toString()));

                                    DataStorage.getInstance().addHydro(hyd);
                                    Intent billIntent = new Intent(AddNewBillActivity.this, ShowBillDetailsActivity.class);
                                    startActivity(billIntent);
                                }
                            }
                        });

                    case 1:
                        txtNew1.setHint("Enter Provider Name");
                       txtNew2.setHint("Internet GB used");
                        txtNew3.setVisibility(View.INVISIBLE);
                        txtNew4.setVisibility(View.INVISIBLE);
                        txtNew5.setVisibility(View.INVISIBLE);
                        billSaveButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (txtNewBillID.getText().toString().isEmpty()) {
                                    txtNewBillID.setError("Please enter Bill ID");
                                } else if (txtNewBillDate.getText().toString().isEmpty()) {
                                    txtNewBillDate.setError("Please select Bill Date");
                                } else if (txtNew1.getText().toString().isEmpty()) {
                                    txtNew1.setError("Please enter Provider Name");
                                } else if (txtNew2.getText().toString().isEmpty()) {
                                    txtNew2.setError("Please enter Internet GB used");
                                } else if (txtNewBillID.getText().toString().contains("INT")) {

                                    Internet internet = new Internet(txtNewBillID.getText().toString(),
                                            BillType.INTERNET,
                                           txtNewBillDate.getText().toString(),
                                            txtNew1.getText().toString(),
                                            Integer.parseInt(txtNew2.getText().toString()));

                                    DataStorage.getInstance().addInternet(internet);


                                    Intent billIntent = new Intent(AddNewBillActivity.this, ShowBillDetailsActivity.class);
                                    startActivity(billIntent);
                                }
                            }
                        });

                    case 2:
                        txtNew1.setHint("Enter Mobile Manufacturer");
                        txtNew2.setHint("Enter Plan Name");
                       txtNew3.setHint("Enter Mobile Number");
                        txtNew4.setHint("Internet GB Used");
                        txtNew5.setHint("Minutes Used");
                        txtNew3.setVisibility(View.VISIBLE);
                        txtNew4.setVisibility(View.VISIBLE);
                        txtNew5.setVisibility(View.VISIBLE);
                        billSaveButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (txtNewBillID.getText().toString().isEmpty()) {
                                    txtNewBillID.setError("Please enter Bill ID");
                                } else if (txtNewBillDate.getText().toString().isEmpty()) {
                                    txtNewBillDate.setError("Please select Bill Date");
                                } else if (txtNew1.getText().toString().isEmpty()) {
                                   txtNew1.setError("Please enter Mobile Manufacturer");
                                } else if (txtNew2.getText().toString().isEmpty()) {
                                    txtNew2.setError("Please enter Plan Name");
                                } else if (StringUtil.getObj().isValidMobileNumber(txtNew3.getText().toString()) && txtNew3.getText().toString().isEmpty()) {
                                    txtNew3.setError("Please enter Mobile Number");
                                } else if (txtNew4.getText().toString().isEmpty()) {
                                        txtNew4.setError("Please enter Internet GB used");
                                } else if (txtNew5.getText().toString().isEmpty()) {
                                    txtNew5.setError("Please enter Minutes used");
                                } else if (txtNewBillID.getText().toString().contains("MOB")) {


                                    Mobile mob = new Mobile(txtNewBillID.getText().toString(),
                                            BillType.MOBILE,
                                           txtNewBillDate.getText().toString(),
                                            txtNew1.getText().toString(),
                                           txtNew2.getText().toString(),
                                           txtNew3.getText().toString(),
                                            Integer.parseInt(txtNew4.getText().toString()),
                                            Integer.parseInt(txtNew5.getText().toString()));

                                    DataStorage.getInstance().addMobile(mob);

                                    Intent billIntent = new Intent(AddNewBillActivity.this, ShowBillDetailsActivity.class);
                                    startActivity(billIntent);
                                }


                            }
                        });

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}



