/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoImpl;

import com.perficient.talentreviewsystem.entity.TalentReviewScore;
import java.util.List;
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
public class TalentReviewScoreDAOImplTest {
 
    TalentReviewScoreDAOImpl trsdaoi =new TalentReviewScoreDAOImpl();
    EmployeeInfoDAOImpl eidaoi = new EmployeeInfoDAOImpl();
    ReviewPeriodDAOImpl rpdaoi =new ReviewPeriodDAOImpl();
    TalentReviewScore trs = null;
    List<TalentReviewScore> list =null;
       
    public TalentReviewScoreDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        trs = new TalentReviewScore("2","201503");
        trs.setOrgImpact(5);
        trs.setLearningAgility(5);
        trs.setStatus(1);
        trs.setEmployeeInfo(eidaoi.selectEmployeeInfoById("2"));
        trs.setReviewPeriod1(rpdaoi.selectReviewPeriodByRP("201503"));
    }
    
    @After
    public void tearDown() {
    }


    
    @Test
    public void testAddTalentReviewScore() {
       int i =trsdaoi.addTalentReviewScore(trs);
        assertEquals("testAddTalentReviewScore fail", i, 1);
        System.out.println("testAddTalentReviewScore success");
    }


    @Test
    public void testSelectAllTalentReviewScore() {
        list = trsdaoi.selectAllTalentReviewScore();
        assert(list.size()>0);
        System.out.println("testSelectAllTalentReviewScore success");
    }


    @Test
    public void testSelectSingleByBoth() {

      assert( trsdaoi.selectSingleByBoth("2", "201503")!=null);
        System.out.println("testSelectSingleByBoth success");
    }


    @Test
    public void testUpdateTalentReviewScore() {
        trs.setOrgImpact(4);
        int i =trsdaoi.updateTalentReviewScore(trs);
        assertEquals("testUpdateTalentReviewScore fail", i, 1);
        System.out.println("testUpdateTalentReviewScore success");
    }


    @Test
    public void testDeleteTalentReviewScore() {
            int i= trsdaoi.deleteTalentReviewScore("2","201503");
            assertEquals("testDeleteTalentReviewScore fail", i, 1);
       
           System.out.println("testDeleteTalentReviewScore success");
    }
    
}
