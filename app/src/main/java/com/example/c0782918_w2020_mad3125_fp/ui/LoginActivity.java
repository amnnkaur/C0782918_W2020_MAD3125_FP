package com.example.c0782918_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;

import com.example.c0782918_w2020_mad3125_fp.R;
import com.example.c0782918_w2020_mad3125_fp.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        getSupportActionBar().hide();

        ArrayList<String> emailArrayList = new ArrayList<>();
        ArrayList<String> passwordArrayList = new ArrayList<>();

        mainBinding.swRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(EMAIL, mainBinding.txtEmail.toString());
                editor.putString(PASSWORD, mainBinding.txtPassword.toString());

            }
        });

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

       // mainBinding.btnLogin.

    }


}
