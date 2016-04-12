/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoimpl;

import com.perficient.talentreviewsystem.daoimpl.ReviewPeriodDAOImpl;
import com.perficient.talentreviewsystem.entity.Rp;
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

    ReviewPeriodDAOImpl rpdaoi = new ReviewPeriodDAOImpl();
    Rp rp = new Rp("999999");

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
        rp.setId(999);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of selectReviewPeriodByRP method, of class ReviewPeriodDAOImpl.
     */
    @Test
    public void testSelectReviewPeriodByRP() {
        Rp rp = rpdaoi.selectReviewPeriodByRP("201503");
        assert (rp != null);
        System.err.println("testSelectReviewPeriodByRP success");
    }

    @Test
    public void testAddReviewPeriod() {
        int i = rpdaoi.addReviewPeriod(rp);
        assert (i == 1);
        System.out.println("testAddReviewPeriod success");
        rpdaoi.deleteReviewPeriod(rp.getReviewPeriod());
    }

    @Test
    public void testDeleteReviewPeriod() {
        int i;
        rpdaoi.addReviewPeriod(rp);
        i = rpdaoi.deleteReviewPeriod(rp.getReviewPeriod());
        assert (i == 1);
        System.out.println("testDeleteReviewPeriod success");
    }

    @Test
    public void teatFindMaxRp() {
        rpdaoi.addReviewPeriod(rp);
        assertEquals(rpdaoi.findMaxRp(), rp.getReviewPeriod());
        System.out.println("teatFindMaxRp success");
        rpdaoi.deleteReviewPeriod(rp.getReviewPeriod());
    }

}
