/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.dao.JUnitTest;

import com.perficient.talentreviewsystem.dao.IReviewPeriodDAO;
import com.perficient.talentreviewsystem.daoImpl.ReviewPeriodDAOImpl;
import com.perficient.talentreviewsystem.entity.ReviewPeriod;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bootcamp19
 */
public class IReviewPeriodDAOTest {
    
    public IReviewPeriodDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of selectReviePeriodByRP method, of class IReviewPeriodDAO.
     */
    @Test
    public void testSelectReviePeriodByRP() {
        System.out.println("selectReviePeriodByRP");
        String rp = "201503";
        IReviewPeriodDAO instance = new ReviewPeriodDAOImpl();
        ReviewPeriod expResult = new ReviewPeriod();
        expResult.setId(1);
        expResult.setReviewPeriod("201503");
        ReviewPeriod result = instance.selectReviewPeriodByRP(rp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       //S fail("The test case is a prototype.");
    }

//    public class IReviewPeriodDAOImpl implements IReviewPeriodDAO {
//
//        public ReviewPeriod selectReviePeriodByRP(String rp) {
//            return null;
//        }
//    }
    
}
