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
public class HttpConnectionTest {
    
    public HttpConnectionTest() {
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
     * Test of getFromUrl method, of class HttpConnection.
     */
    @Test
    public void testGetFromUrl() {
        String url = "http://10.2.1.207:8080/tpt2013-portlet/resteasy/employees";
        String result = HttpConnection.getFromUrl(url);
        assertTrue(result.contains("id"));
        assertTrue(result.contains("type"));
        assertTrue(result.contains("role"));
        assertTrue(result.contains("title"));
        assertTrue(result.contains("active"));
        assertTrue(result.contains("firstName"));
        assertTrue(result.contains("lastName"));
        assertTrue(result.contains("screenName"));
        assertTrue(result.contains("gender"));
        assertTrue(result.contains("emid"));
        assertTrue(result.contains("lastUpdated"));
        assertTrue(result.contains("onBoardDate"));
        assertTrue(result.contains("photoURL"));
        assertTrue(result.contains("bu"));
        assertTrue(result.contains("workStartDate"));
        assertTrue(result.contains("lineManager"));
        assertTrue(result.contains("lastDay"));
    }
    
}
