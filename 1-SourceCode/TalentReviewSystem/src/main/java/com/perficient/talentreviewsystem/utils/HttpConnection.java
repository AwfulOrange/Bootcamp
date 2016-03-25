/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bootcamp19
 */
public class HttpConnection {
        
    private HttpConnection(){}

    public  static String getFromUrl(String url) {
    String result = "";
    BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        finally {
            try {
                in.close();
            } catch (Exception e2) {
                Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, e2);
            }
        }
        return result;
    
    }
      
        
}
