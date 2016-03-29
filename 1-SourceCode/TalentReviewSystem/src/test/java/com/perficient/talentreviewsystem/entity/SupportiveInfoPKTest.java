/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

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
public class SupportiveInfoPKTest {
    SupportiveInfoPK s = new SupportiveInfoPK();
    String employeeId="1";
    String reviewPeriod="201503";
    
    public SupportiveInfoPKTest() {
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

    @Test
    public void testEmployeeId() {
        s= new SupportiveInfoPK();
        s.setReviewPeriod(reviewPeriod);
        assertEquals(reviewPeriod,s.getReviewPeriod());
    }

    @Test
    public void testReviewPeriod() {
        s = new SupportiveInfoPK();
        s.setEmployeeId(employeeId);
        assertEquals(employeeId,s.getEmployeeId());
    }
}
