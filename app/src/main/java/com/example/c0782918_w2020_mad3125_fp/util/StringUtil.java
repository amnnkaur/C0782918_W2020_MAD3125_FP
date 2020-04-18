package com.example.c0782918_w2020_mad3125_fp.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String convertIntToString(int value){
        return (String.valueOf(value));
    }

    public static String convertDoubleToString(Double value){
        DecimalFormat df = new DecimalFormat("#.##");

        return ("$" + String.valueOf(df.format(value)));
    }

    public static String convertStringToDate(Date date)
    {
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        return(df.format(date));
    }


    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

}
