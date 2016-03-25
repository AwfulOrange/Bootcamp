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
public class GetPropertyTest {
    
    public GetPropertyTest() {
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
     * Test of getString method, of class GetProperty.
     */
    @Test
    public void testGetString() {
        String key = "tptPath";
        GetProperty instance = new GetProperty();
        String expResult = "http://10.2.1.207:8080/tpt2013-portlet/resteasy/employees";
        String result = instance.getString(key);
        assertEquals(expResult, result);
    }
    
}
