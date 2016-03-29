/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.utils;

import java.util.Date;
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
public class DateUtilsTest {
    
    public DateUtilsTest() {
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
     * Test of formatDate method, of class DateUtils.
     */
    @Test
    public void testFormatDate() {
        Date date = new Date(1459215981559L);
        String expResult = "2016-03-29";
        String result = DateUtils.formatDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of toDate method, of class DateUtils.
     */
    @Test
    public void testToDate() {
        String dateStr = "1459215981559";
        String expResult = "2016-03-29";
        String result = DateUtils.toDate(dateStr);
        assertEquals(expResult, result);
    }
    
}
