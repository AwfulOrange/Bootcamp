/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceimpl;

import com.perficient.talentreviewsystem.daoimpl.EmployeeInfoDAOImpl;
import com.perficient.talentreviewsystem.daoimpl.TalentReviewScoreDAOImpl;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
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
    EmployeeInfoDAOImpl eidaoi = new EmployeeInfoDAOImpl();
    EmployeeInfo ei = new EmployeeInfo();
    List<TalentReviewScore> scoreList = new ArrayList<TalentReviewScore>();
    TalentReviewScore trScore = new TalentReviewScore();
    TalentReviewScoreDAOImpl trsdaoi = new TalentReviewScoreDAOImpl();
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
        trScore.setEmployeeId("76");
        trScore.setAchievingResults(1);
        trScore.setAchievingResultsComment("a");
        trScore.setLearningAgility(2);
        trScore.setLearningAgilityComment("b");
        trScore.setOrgImpact(3);
        trScore.setOrgImpactComment("c");
        trScore.setVersatility(4);
        trScore.setVersatilityComment("d");
        trScore.setStatus("Modified");
        trScore.setReviewerId("212");
        trScore.setPmoId("212");
        ei.setEmployeeId("76");
        eidaoi.addEmployeeInfo(ei);
    }
    
    @After
    public void tearDown() {
        eidaoi.deleteEmployeeInfoById("76");
        trsdaoi.deleteTalentReviewScore("76", "201503");
    }

    /**
     * Test of add method, of class TalentReviewScoreServiceImpl.
     */
    @Test
    public void testAdd() {
       
        scoreList.add(trScore);
        TalentReviewScoreServiceImpl instance = new TalentReviewScoreServiceImpl();
        int expResult = 1;
        int result = instance.add(scoreList);
        assertEquals(expResult, result);
    }
    
}
