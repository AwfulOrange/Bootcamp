/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.utils;

import java.util.Date;

/**
 *
 * @author bootcamp19
 */
public class DateUtils {
    
    public static String calcuDate(String date){
        long joinTime = Long.parseLong(date);
        Date nowTime = new Date();
        long exp = 0;
        exp = nowTime.getTime() - joinTime;
        
        int year = 0;
        int month = 0;
        year = ParseUtil.longToInt(exp / 1000 / 3600 / 24 / 365);
        String expStr = year + "year";
        if(year > 1){
            expStr += "s";
        }
        
        month = ParseUtil.longToInt(exp/1000/3600/24) - (365 * year);
        month /= 30;
        expStr = expStr + " "+month+"month";
        if(month > 1){
            expStr += "s";
        }
        
        return expStr;
    }
}
