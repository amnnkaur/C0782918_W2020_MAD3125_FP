package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    private MyHandlers handlers;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    ArrayList<String> emailArrayList;
    ArrayList<String> passwordArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        getSupportActionBar().hide();

        handlers = new MyHandlers(this);
        mainBinding.setMyHandler(handlers);

         sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
         editor = sharedPreferences.edit();

        emailArrayList = new ArrayList<>();
        passwordArrayList = new ArrayList<>();

        String email = sharedPreferences.getString(EMAIL, null);
        String password = sharedPreferences.getString(PASSWORD, null);

        mainBinding.txtEmail.setText(email);
        mainBinding.txtPassword.setText(password);

        editor.putString(EMAIL, mainBinding.txtEmail.toString());
        editor.putString(PASSWORD, mainBinding.txtPassword.toString());

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset("usersLogin.json"));
            JSONArray userArray = obj.getJSONArray("users");
            for (int i = 0; i < userArray.length(); i++)
            {
                JSONObject userInfo = userArray.getJSONObject(i);
                emailArrayList.add(userInfo.getString("email"));
                passwordArrayList.add(userInfo.getString("password"));
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
/*
        mainBinding.swRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });*/


    }

    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream inputStream = getAssets().open(filename);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    public class MyHandlers {

        Context context;

        public MyHandlers(Context context) {
            this.context = context;
        }

        public void onBtnSubmitClicked(View view) {

            if (mainBinding.txtEmail.getText().toString().isEmpty()) {
                mainBinding.txtEmail.setError("Enter your email address");
            } else if (mainBinding.txtPassword.getText().toString().isEmpty()) {
                mainBinding.txtPassword.setError("Enter your password");
            } else {
                for (int i = 0; i < emailArrayList.size(); i++)
                {
                    if (emailArrayList.get(i).equals(mainBinding.txtEmail.getText().toString()) && passwordArrayList.get(i).equals(mainBinding.txtPassword.getText().toString())) {

                        if (mainBinding.swRememberMe.isChecked()) {

                            editor.putString(EMAIL, mainBinding.txtEmail.getText().toString());
                            editor.putString(PASSWORD, mainBinding.txtPassword.getText().toString());
                            editor.apply();

                        } else {
                            editor.putString(EMAIL, "");
                            editor.putString(PASSWORD, "");
                            editor.apply();
                        }

                        Intent mIntent = new Intent(LoginActivity.this, CustomerListActivity.class);
                        startActivity(mIntent);
                        return;
                    }
                }
            }

            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(LoginActivity.this);
            alertBuilder.setTitle("Error!");
            alertBuilder.setMessage("Invalid Email or Password.");
            alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
                    .show();
            return;

        }

    }

}
