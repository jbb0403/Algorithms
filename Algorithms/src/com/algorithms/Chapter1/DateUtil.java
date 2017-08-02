package com.algorithms.Chapter1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.S");

    public static String format(Date date){
        synchronized(sdf){
            return sdf.format(date);
        }

    }

    public static Date parse(String strDate){
        try{
            synchronized(sdf){
                return sdf.parse(strDate);
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}