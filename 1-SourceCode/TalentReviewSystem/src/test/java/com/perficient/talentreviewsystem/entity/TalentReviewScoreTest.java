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
public class TalentReviewScoreTest {
    TalentReviewScore t = new TalentReviewScore();
    Integer achievingResults=1;
    String achievingResultsComment="achievingResultsComment";
    Integer learningAgility=1;
    String learningAgilityComment="learningAgilityComment";
    Integer orgImpact=1;
    String orgImpactComment="orgImpactComment";
    Integer versatility=1;
    String versatilityComment="versatilityComment";
    String status="Modified";
    String reviewerId="1";
    String pmoId="1";
    String employeeId="1";
    public TalentReviewScoreTest() {
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
    public void testAchievingResults() {
        t = new TalentReviewScore();
        t.setAchievingResults(achievingResults);
        assertEquals(achievingResults,t.getAchievingResults());
    }


    @Test
    public void testAchievingResultsComment() {
        t = new TalentReviewScore();
        t.setAchievingResultsComment(achievingResultsComment);
        assertEquals(achievingResultsComment,t.getAchievingResultsComment());
    }

    @Test
    public void testLearningAgility() {
        t = new TalentReviewScore();
        t.setLearningAgility(learningAgility);
        assertEquals(learningAgility,t.getLearningAgility());
    }

    @Test
    public void testLearningAgilityComment() {
        t = new TalentReviewScore();
        t.setLearningAgilityComment(learningAgilityComment);
        assertEquals(learningAgilityComment,t.getLearningAgilityComment());
    }

    @Test
    public void testOrgImpact() {
         t = new TalentReviewScore();
         t.setOrgImpact(orgImpact);
         assertEquals(orgImpact,t.getOrgImpact());
    }

    @Test
    public void testOrgImpactComment() {
         t = new TalentReviewScore();
         t.setOrgImpactComment(orgImpactComment);
         assertEquals(orgImpactComment,t.getOrgImpactComment());
    }

    @Test
    public void testVersatility() {
         t = new TalentReviewScore();
         t.setVersatility(versatility);
         assertEquals(versatility,t.getVersatility());
    }

    @Test
    public void testVersatilityComment() {
         t = new TalentReviewScore();
         t.setVersatilityComment(versatilityComment);
         assertEquals(versatilityComment,t.getVersatilityComment());
    }

    @Test
    public void testStatus() {
       t = new TalentReviewScore();
       t.setStatus(status);
       assertEquals(status,t.getStatus());
    }


    @Test
    public void testReviewerId() {
        t = new TalentReviewScore();
        t.setReviewerId(reviewerId);
        assertEquals(reviewerId,t.getReviewerId());
    }

    @Test
    public void testPmoId() {
       t = new TalentReviewScore();
       t.setPmoId(pmoId);
       assertEquals(pmoId,t.getPmoId());
    }


    @Test
    public void testEmployeeId() {
        t = new TalentReviewScore();
        t.setEmployeeId(employeeId);
        assertEquals(employeeId,t.getEmployeeId());
    }

}
