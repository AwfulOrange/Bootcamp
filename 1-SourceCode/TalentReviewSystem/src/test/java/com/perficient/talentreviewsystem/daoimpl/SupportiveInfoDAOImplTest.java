/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoimpl;

import com.perficient.talentreviewsystem.entity.SupportiveInfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
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
public class SupportiveInfoDAOImplTest {

    SupportiveInfoDAOImpl sidaoi = new SupportiveInfoDAOImpl();
    EntityManager enm = Persistence.createEntityManagerFactory("com.perficient_TalentReviewSystem_war_1.0-SNAPSHOTPU").createEntityManager();
    SupportiveInfo su = new SupportiveInfo();
    UserTransaction utx = null;
    
    
    public SupportiveInfoDAOImplTest() {
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
     * Test of selectAllSupportiveInfo method, of class SupportiveInfoDAOImpl.
     */
//    @Test
//    public void testAddSupportiveInfo() throws Exception {
//        String empId= "212";
//        
//    }
    
    @Test
    public void testSelectAllSupportiveInfo() {
        List<SupportiveInfo> list = sidaoi.selectAllSupportiveInfo();
        assert(list.size()>0);
    }

    /**
     * Test of selectSupportiveInfoByBoth method, of class
     * SupportiveInfoDAOImpl.
     */
    @Test
    public void testSelectSupportiveInfoByBoth() {
        assert(sidaoi.selectSupportiveInfoByBoth("212", "201503")!=null);
    }

}
