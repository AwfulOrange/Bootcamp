/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bootcamp19
 */
public class GetPropertiesTest {
    
    public GetPropertiesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProperty method, of class GetProperties.
     */
    @Test
    public void testGetProperty() {
        String key = "tptPath";
        GetProperties instance = new GetProperties();
        GetProperties instance2 = new GetProperties(key);
        String expResult = "http://10.2.1.207:8080/tpt2013-portlet/resteasy/employees";
        String result = instance.getProperty(key);
        assertEquals(expResult, result);
    }
    
}
