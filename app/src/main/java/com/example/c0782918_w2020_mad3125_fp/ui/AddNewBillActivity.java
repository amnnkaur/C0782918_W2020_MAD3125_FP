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
import android.widget.Spinner;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityAddNewBillBinding;
import com.example.c0782918_w2020_mad3125_fp.model.Bill;
import com.example.c0782918_w2020_mad3125_fp.model.BillType;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.model.Internet;
import com.example.c0782918_w2020_mad3125_fp.model.Mobile;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;
import com.example.c0782918_w2020_mad3125_fp.util.StringUtil;

public class AddNewBillActivity extends AppCompatActivity {

    ActivityAddNewBillBinding addNewBillBinding;

    String[] billType = {"Hydro", "Internet", "Mobile"};

    Mobile mobile;
    Hydro hydro;
    Internet internet;
    ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addNewBillBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_bill);

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, billType);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        addNewBillBinding.spinnerBillType.setAdapter(spinnerAdapter);

        addNewBillBinding.spinnerBillType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:
                        addNewBillBinding.txtNew1.setHint("Enter Agency Name");
                        addNewBillBinding.txtNew2.setHint("Units Consumed");
                        addNewBillBinding.txtNew3.setVisibility(View.INVISIBLE);
                        addNewBillBinding.txtNew4.setVisibility(View.INVISIBLE);
                        addNewBillBinding.txtNew5.setVisibility(View.INVISIBLE);

                        addNewBillBinding.billSaveButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (addNewBillBinding.txtNewBillID.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNewBillID.setError("Please enter Bill ID");
                                } else if (addNewBillBinding.txtNewBillDate.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNewBillDate.setError("Please select Bill Date");
                                } else if (addNewBillBinding.txtNew1.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNew1.setError("Please enter Agency Name");
                                } else if (addNewBillBinding.txtNew2.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNew2.setError("Please enter Units Consumed");
                                } else if (addNewBillBinding.txtNewBillID.getText().toString().contains("HYD")) {

                                    Hydro hyd = new Hydro(addNewBillBinding.txtNewBillID.getText().toString(),
                                            BillType.HYDRO,
                                            addNewBillBinding.txtNewBillDate.getText().toString(),
                                            addNewBillBinding.txtNew1.getText().toString(),
                                            Integer.parseInt(addNewBillBinding.txtNew2.getText().toString()));

                                    DataStorage.getInstance().addHydro(hyd);
                                    Intent billIntent = new Intent(AddNewBillActivity.this, ShowBillDetailsActivity.class);
                                    startActivity(billIntent);
                                }
                            }
                        });

                    case 1:
                        addNewBillBinding.txtNew1.setHint("Enter Provider Name");
                        addNewBillBinding.txtNew2.setHint("Internet GB used");
                        addNewBillBinding.txtNew3.setVisibility(View.INVISIBLE);
                        addNewBillBinding.txtNew4.setVisibility(View.INVISIBLE);
                        addNewBillBinding.txtNew5.setVisibility(View.INVISIBLE);
                        addNewBillBinding.billSaveButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (addNewBillBinding.txtNewBillID.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNewBillID.setError("Please enter Bill ID");
                                } else if (addNewBillBinding.txtNewBillDate.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNewBillDate.setError("Please select Bill Date");
                                } else if (addNewBillBinding.txtNew1.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNew1.setError("Please enter Provider Name");
                                } else if (addNewBillBinding.txtNew2.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNew2.setError("Please enter Internet GB used");
                                } else if (addNewBillBinding.txtNewBillID.getText().toString().contains("INT")) {

                                    Internet internet = new Internet(addNewBillBinding.txtNewBillID.getText().toString(),
                                            BillType.INTERNET,
                                            addNewBillBinding.txtNewBillDate.getText().toString(),
                                            addNewBillBinding.txtNew1.getText().toString(),
                                            Integer.parseInt(addNewBillBinding.txtNew2.getText().toString()));

                                    DataStorage.getInstance().addInternet(internet);


                                    Intent billIntent = new Intent(AddNewBillActivity.this, ShowBillDetailsActivity.class);
                                    startActivity(billIntent);
                                }
                            }
                        });

                    case 2:
                        addNewBillBinding.txtNew1.setHint("Enter Mobile Manufacturer");
                        addNewBillBinding.txtNew2.setHint("Enter Plan Name");
                        addNewBillBinding.txtNew3.setHint("Enter Mobile Number");
                        addNewBillBinding.txtNew4.setHint("Internet GB Used");
                        addNewBillBinding.txtNew5.setHint("Minutes Used");
                        addNewBillBinding.txtNew3.setVisibility(View.VISIBLE);
                        addNewBillBinding.txtNew4.setVisibility(View.VISIBLE);
                        addNewBillBinding.txtNew5.setVisibility(View.VISIBLE);
                        addNewBillBinding.billSaveButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (addNewBillBinding.txtNewBillID.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNewBillID.setError("Please enter Bill ID");
                                } else if (addNewBillBinding.txtNewBillDate.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNewBillDate.setError("Please select Bill Date");
                                } else if (addNewBillBinding.txtNew1.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNew1.setError("Please enter Mobile Manufacturer");
                                } else if (addNewBillBinding.txtNew2.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNew2.setError("Please enter Plan Name");
                                } else if (StringUtil.getObj().isValidMobileNumber(addNewBillBinding.txtNew3.getText().toString()) && addNewBillBinding.txtNew3.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNew3.setError("Please enter Mobile Number");
                                } else if (addNewBillBinding.txtNew4.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNew4.setError("Please enter Internet GB used");
                                } else if (addNewBillBinding.txtNew5.getText().toString().isEmpty()) {
                                    addNewBillBinding.txtNew5.setError("Please enter Minutes used");
                                } else if (addNewBillBinding.txtNewBillID.getText().toString().contains("MOB")) {


                                    Mobile mob = new Mobile(addNewBillBinding.txtNewBillID.getText().toString(),
                                            BillType.MOBILE,
                                            addNewBillBinding.txtNewBillDate.getText().toString(),
                                            addNewBillBinding.txtNew1.getText().toString(),
                                            addNewBillBinding.txtNew2.getText().toString(),
                                            addNewBillBinding.txtNew3.getText().toString(),
                                            Integer.parseInt(addNewBillBinding.txtNew4.getText().toString()),
                                            Integer.parseInt(addNewBillBinding.txtNew5.getText().toString()));

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

    public class NewBillHandler {

        Context context;

        public NewBillHandler(Context context) {
            this.context = context;
        }

        public void onSaveBtnClicked(View view) {


        }

    }
}



