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
public class TalentReviewScorePKTest {
    TalentReviewScorePK t = new TalentReviewScorePK();
    String employee_id="1";
    String reviewPeriod="201503";
    
    public TalentReviewScorePKTest() {
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
        t = new TalentReviewScorePK();
        t.setEmployeeId(employee_id);
        assertEquals(employee_id,t.getEmployeeId());
        
    }

    @Test
    public void testReviewPeriod() {
       t = new TalentReviewScorePK();
       t.setReviewPeriod(reviewPeriod);
       assertEquals(reviewPeriod,t.getReviewPeriod());
    }

}
