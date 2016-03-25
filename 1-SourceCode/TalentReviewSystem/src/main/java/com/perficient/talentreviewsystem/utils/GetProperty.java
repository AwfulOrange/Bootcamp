package com.perficient.talentreviewsystem.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bootcamp19
 */
public class GetProperty {
    private Properties properties = new Properties();
    public GetProperty(){
        try {
            File file = new File(GetProperty.class.getResource("/META-INF/config.properties").getPath()); 
            properties.load(new FileInputStream(file));
        } catch (IOException ex) {
            Logger.getLogger(GetProperty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getString(String key) {
        return properties.getProperty(key);
    }
    
    
}
    
