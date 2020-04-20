package com.example.c0782918_w2020_mad3125_fp.ui;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.adapter.HydAdapter;
import com.example.c0782918_w2020_mad3125_fp.adapter.InternetAdapter;
import com.example.c0782918_w2020_mad3125_fp.adapter.MobileAdapter;
import com.example.c0782918_w2020_mad3125_fp.model.Bill;
import com.example.c0782918_w2020_mad3125_fp.model.BillType;
import com.example.c0782918_w2020_mad3125_fp.model.Customer;
import com.example.c0782918_w2020_mad3125_fp.model.Hydro;
import com.example.c0782918_w2020_mad3125_fp.model.Internet;
import com.example.c0782918_w2020_mad3125_fp.model.Mobile;
import com.example.c0782918_w2020_mad3125_fp.singleton.DataStorage;
import com.example.c0782918_w2020_mad3125_fp.util.StringUtil;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Calendar;
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
    private TextInputLayout universalTextView1;
    private TextInputLayout universalTextView2;
    private TextInputLayout universalTextView3;
    private TextInputLayout universalTextView4;
    private TextInputLayout universalTextView5;
    String[] billType = {"Hydro", "Internet", "Mobile"};
    Mobile mobile;
    Hydro hydro;
    Internet internet;
    ArrayAdapter spinnerAdapter;
    String customer;
    Customer object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_bill);

        Intent fetch = getIntent();
        if(fetch.hasExtra("customerID")){
            customer = fetch.getStringExtra("customerID");
        }
        Toast.makeText(AddNewBillActivity.this, customer, Toast.LENGTH_SHORT).show();
        txtNewBillID = findViewById(R.id.txtNewBillID);
        txtNewBillDate = findViewById(R.id.txtNewBillDate);
        txtNew1 = findViewById(R.id.txtNew1);
        txtNew2 = findViewById(R.id.txtNew2);
        txtNew3 = findViewById(R.id.txtNew3);
        txtNew4 = findViewById(R.id.txtNew4);
        txtNew5 = findViewById(R.id.txtNew5);
        universalTextView1 = findViewById(R.id.TextView1);
        universalTextView2 = findViewById(R.id.TextView2);
        universalTextView3 = findViewById(R.id.TextView3);
        universalTextView4 = findViewById(R.id.TextView5);
        universalTextView5 = findViewById(R.id.TextView6);
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
                        universalTextView1.setHint("Enter Agency Name");
                        universalTextView2.setHint("Units Consumed");
                        universalTextView3.setVisibility(View.GONE);
                        universalTextView4.setVisibility(View.GONE);
                        universalTextView5.setVisibility(View.GONE);
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
                                } else  {
                                    Hydro hyd = new Hydro(customer,txtNewBillID.getText().toString(),
                                            BillType.HYDRO,
                                            txtNewBillDate.getText().toString(),
                                            txtNew1.getText().toString(),
                                            Integer.parseInt(txtNew2.getText().toString()));
                                    DataStorage.getInstance().addHydro(hyd);
                                    HydAdapter.lastIndex +=1;
                                    Intent billIntent = new Intent(AddNewBillActivity.this, CustomerListActivity.class);
                                    startActivity(billIntent);
                                }
                            }
                        });
                        break;
                    case 1:
                        universalTextView1.setHint("Enter Provider Name");
                        universalTextView2.setHint("Internet GB used");
                        universalTextView3.setVisibility(View.GONE);
                        universalTextView4.setVisibility(View.GONE);
                        universalTextView5.setVisibility(View.GONE);
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
                                } else  {
                                    Internet internet = new Internet(customer,txtNewBillID.getText().toString(),
                                            BillType.INTERNET,
                                            txtNewBillDate.getText().toString(),
                                            txtNew1.getText().toString(),
                                            Integer.parseInt(txtNew2.getText().toString()));
                                    DataStorage.getInstance().addInternet(internet);
                                    InternetAdapter.lastIndex +=1;
                                    Intent billIntent = new Intent(AddNewBillActivity.this, CustomerListActivity.class);
                                    startActivity(billIntent);
                                }
                            }
                        });
                        break;
                    case 2:
                        universalTextView3.setVisibility(View.VISIBLE);
                        universalTextView4.setVisibility(View.VISIBLE);
                        universalTextView5.setVisibility(View.VISIBLE);
                        universalTextView1.setHint("Enter Mobile Manufacturer");
                        universalTextView2.setHint("Enter Plan Name");
                        universalTextView3.setHint("Enter Mobile Number");
                        universalTextView4.setHint("Internet GB Used");
                        universalTextView5.setHint("Minutes Used");
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
                                } else {
                                    Mobile mob = new Mobile(customer,txtNewBillID.getText().toString(),
                                            BillType.MOBILE,
                                            txtNewBillDate.getText().toString(),
                                            txtNew1.getText().toString(),
                                            txtNew2.getText().toString(),
                                            txtNew3.getText().toString(),
                                            Integer.parseInt(txtNew4.getText().toString()),
                                            Integer.parseInt(txtNew5.getText().toString()));
                                    DataStorage.getInstance().addMobile(mob);
                                    MobileAdapter.lastIndex +=1;
                                    Intent billIntent = new Intent(AddNewBillActivity.this, CustomerListActivity.class);
                                    startActivity(billIntent);
                                }
                            }
                        });
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void dateImageButton(View view){
        DatePickerDialog datePickerDialog;
        // Calendar object to hold the selected data
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
// date picker dialog
        datePickerDialog = new DatePickerDialog(AddNewBillActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        txtNewBillDate.setText(dayOfMonth+"/"+(monthOfYear + 1)+"/"+year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}