/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.utils;

/**
 *
 * @author bootcamp19
 */
public class ParseUtil {
    public static int longToInt(long longStr){
        return Integer.parseInt(Long.toString(longStr));
    }
    
    public static long intToLong(int intStr){
        return Long.parseLong(Integer.toString(intStr));
    }
}
