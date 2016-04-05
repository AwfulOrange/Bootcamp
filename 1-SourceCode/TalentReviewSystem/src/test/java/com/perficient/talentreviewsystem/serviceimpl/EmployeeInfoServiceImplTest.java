/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceimpl;

import com.perficient.talentreviewsystem.daoimpl.EmployeeInfoDAOImpl;
import com.perficient.talentreviewsystem.daoimpl.ReviewPeriodDAOImpl;
import com.perficient.talentreviewsystem.daoimpl.TalentReviewScoreDAOImpl;
import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import com.perficient.talentreviewsystem.entity.Group;
import com.perficient.talentreviewsystem.entity.ReviewPeriod;
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
public class EmployeeInfoServiceImplTest {
    TalentReviewScoreDAOImpl trsdaoi = new TalentReviewScoreDAOImpl();
    EmployeeInfoDAOImpl eidaoi = new EmployeeInfoDAOImpl();
    ReviewPeriodDAOImpl rpdaoi = new ReviewPeriodDAOImpl();
    EmployeeInfo ei = new EmployeeInfo();
    ReviewPeriod rp = new ReviewPeriod();
    TalentReviewScore trs = null;
    List<TalentReviewScore> list = null;
    
    public EmployeeInfoServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ei.setEmployeeId("99998");
        eidaoi.addEmployeeInfo(ei);
        trs = new TalentReviewScore("99998", "201503");
        trs.setOrgImpact(5);
        trs.setLearningAgility(5);
        trs.setAchievingResults(3);
        trs.setVersatility(2);
        trs.setStatus(1);
        trs.setReviewerId("999999");
        trs.setPmoId("999");
        trs.setEmployeeInfo(eidaoi.selectEmployeeInfoById("99998"));
        trs.setReviewPeriod1(rpdaoi.selectReviewPeriodByRP("201503"));
    }
    
    @After
    public void tearDown() {
        eidaoi.deleteEmployeeInfoById("99998");
    }

    /**
     * Test of findAll method, of class EmployeeInfoServiceImpl.
     */
    @Test
    public void findAllByReviewerID() {
        EmployeeInfoServiceImpl instance = new EmployeeInfoServiceImpl();
        List<Employee> result1 = instance.findAllByReviewerID("99998");
       
        assertNotNull(result1);
       
        //fail("The test case is a prototype.");
    }
    @Test
    public void findAllByPMOID() {
        EmployeeInfoServiceImpl instance = new EmployeeInfoServiceImpl();
        List<Group> result2=instance.findAllByPMOID("99998");
        assertNotNull(result2);
    }

 
}
