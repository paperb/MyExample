package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils{
    private DateUtils(){}

    public static String dateToString(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(date);
        return s;
    }

    public static Date stringToDate(String s,String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = sdf.parse(s);
        return d;
    }

    public static Date parse(String time) {
        try {
            Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(Double.parseDouble(time));
            return date;
        } catch (Exception e) {
            return null;
        }
    }
}
