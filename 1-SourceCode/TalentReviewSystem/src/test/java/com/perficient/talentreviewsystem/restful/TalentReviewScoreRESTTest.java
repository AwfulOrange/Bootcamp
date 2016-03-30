/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bootcamp19
 */
public class TalentReviewScoreRESTTest {
    public TalentReviewScoreREST talentRviewScore;

    private IMocksControl mockControl;

    public TalentReviewScoreRESTTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mockControl = EasyMock.createControl();
        talentRviewScore = mockControl.createMock(TalentReviewScoreREST.class);
    }
    
    @After
    public void tearDown() {
         talentRviewScore = null;
    }

    /**
     * Test of addScore method, of class TalentReviewScoreREST.
     */
    @Test
    public void testAddScore() throws Exception {
        String Json = "[{\"employeeId\":\"1505\",\"achievingResults\":3,\"orgImpact\":3,\"learningAgility\":3,\"versatility\":5,\"achievingResultsComment\"\n" +
":\"r\",\"orgImpactComment\":\"wf\",\"learningAgilityComment\":\"a2\",\"versatilityComment\":\"a\",\"status\":1,\"reviewerId\"\n" +
":\"212\"},{\"employeeId\":\"1792\",\"achievingResults\":1,\"orgImpact\":3,\"learningAgility\":2,\"versatility\":4,\"achievingResultsComment\"\n" +
":\"b\",\"orgImpactComment\":\"c\",\"learningAgilityComment\":\"b\",\"versatilityComment\":\"d\",\"status\":1,\"reviewerId\"\n" +
":\"212\"}]";
        EasyMock.expect(talentRviewScore.addScore(Json)).andReturn(1).once();
        mockControl.replay();
        assertEquals(1, talentRviewScore.addScore(Json));
        mockControl.verify();
        
    }
    
}
