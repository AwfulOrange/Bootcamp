/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.System.console;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bootcamp19
 */
public class GetProperties {
    private Properties properties = new Properties();

    public GetProperties() {
        try {
            File file = new File(GetProperties.class.getResource("/META-INF/config.properties").getPath());
            properties.load(new FileInputStream(file));
        } catch (IOException ex) {
            Logger.getLogger(GetProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public GetProperties(String path) {
        try {
            File file = new File(GetProperties.class.getResource(path).getPath());
            properties.load(new FileInputStream(file));
        } catch (IOException ex) {
            Logger.getLogger(GetProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
