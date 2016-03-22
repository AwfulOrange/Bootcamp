/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoImpl;

import com.perficient.talentreviewsystem.entity.ReviewPeriod;
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
public class ReviewPeriodDAOImplTest {
            ReviewPeriodDAOImpl rpdaoi = new  ReviewPeriodDAOImpl();
        
    public ReviewPeriodDAOImplTest() {
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
     * Test of selectReviewPeriodByRP method, of class ReviewPeriodDAOImpl.
     */
    @Test
    public void testSelectReviewPeriodByRP() {
        ReviewPeriod rp = rpdaoi.selectReviewPeriodByRP("201503");
        assert(rp!=null);
        System.err.println("testSelectReviewPeriodByRP success");
    }
    
}
