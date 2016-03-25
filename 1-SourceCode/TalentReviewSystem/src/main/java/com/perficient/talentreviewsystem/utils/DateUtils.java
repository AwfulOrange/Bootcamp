/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bootcamp19
 */
public class DateUtils {
    
    private DateUtils(){
        
    }
    
    public static String calcuDate(String date){
        long joinTime = Long.parseLong(date);
        Date nowTime = new Date();
        long exp = nowTime.getTime() - joinTime;
        
        int year = (int)(exp / 1000 / 3600 / 24 / 365);
        String expStr = year + "year";
        if(year > 1){
            expStr += "s";
        }
        
        int month = (int)(exp/1000/3600/24) - (365 * year);
        month /= 30;
        expStr = expStr + " "+month+"month";
        if(month > 1){
            expStr += "s";
        }
        
        return expStr;
    }
    
    public static String formatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    
    public static String toDate(String dateStr) {
        Long l = Long.parseLong(dateStr);
        Date date = new Date(l);
        return formatDate(date);
    }
}
