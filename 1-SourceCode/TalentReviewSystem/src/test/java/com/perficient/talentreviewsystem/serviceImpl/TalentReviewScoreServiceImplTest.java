/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceImpl;

import com.perficient.talentreviewsystem.dao.ITalentReviewScoreDAO;
import com.perficient.talentreviewsystem.daoImpl.EmployeeInfoDAOImpl;
import com.perficient.talentreviewsystem.daoImpl.ReviewPeriodDAOImpl;
import com.perficient.talentreviewsystem.daoImpl.TalentReviewScoreDAOImpl;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import com.perficient.talentreviewsystem.entity.ReviewPeriod;
import com.perficient.talentreviewsystem.entity.TalentReviewScore;
import java.util.ArrayList;
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
public class TalentReviewScoreServiceImplTest {
    
    public TalentReviewScoreServiceImplTest() {
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
     * Test of add method, of class TalentReviewScoreServiceImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        List<TalentReviewScore> scoreList = new ArrayList<TalentReviewScore>();
        TalentReviewScore trScore = new TalentReviewScore();
        trScore.setEmployeeId("61");
        trScore.setAchievingResults(1);
        trScore.setAchievingResultsComment("a");
        trScore.setLearningAgility(2);
        trScore.setLearningAgilityComment("b");
        trScore.setOrgImpact(3);
        trScore.setOrgImpactComment("c");
        trScore.setVersatility(4);
        trScore.setVersatilityComment("d");
        trScore.setStatus(1);
        scoreList.add(trScore);
        TalentReviewScoreServiceImpl instance = new TalentReviewScoreServiceImpl();
        int expResult = 1;
        int result = instance.add(scoreList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
