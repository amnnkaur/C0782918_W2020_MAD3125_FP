package com.example.c0782918_w2020_mad3125_fp.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

}
