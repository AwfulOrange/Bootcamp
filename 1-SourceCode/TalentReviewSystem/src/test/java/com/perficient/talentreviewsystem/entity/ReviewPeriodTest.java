/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import java.util.Collection;
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
public class ReviewPeriodTest {
    ReviewPeriod rp = new ReviewPeriod();
     String reviewPeriod="201601";
     Integer id=1;
    public ReviewPeriodTest() {
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
    public void testReviewPeriod() {
        rp = new ReviewPeriod();
        rp.setReviewPeriod(reviewPeriod);
        assertEquals(reviewPeriod,rp.getReviewPeriod());
    }

    @Test
    public void testId() {
      rp = new ReviewPeriod();
      rp.setId(id);
      assertEquals(id,rp.getId());
    }

}
