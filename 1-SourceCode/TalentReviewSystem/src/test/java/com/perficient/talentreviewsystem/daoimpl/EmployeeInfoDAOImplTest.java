/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoimpl;

import com.perficient.talentreviewsystem.daoimpl.EmployeeInfoDAOImpl;
import com.perficient.talentreviewsystem.entity.EmployeeInfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bootcamp19
 */
public class EmployeeInfoDAOImplTest {
     EmployeeInfoDAOImpl eid=new EmployeeInfoDAOImpl();
     EntityManager enm=Persistence.createEntityManagerFactory("com.perficient_TalentReviewSystem_war_1.0-SNAPSHOTPU").createEntityManager();
     EmployeeInfo em=new EmployeeInfo();
     UserTransaction utx=null;
    public EmployeeInfoDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of selectAllEmployeeInfo method, of class EmployeeInfoDAOImpl.
     */
    @Test
    public void testSelectAllEmployeeInfo() {
      List<EmployeeInfo> list=eid.selectAllEmployeeInfo();
        assert(list.size()>0);
    }
    
    /**
     * Test of addEmployeeInfo method, of class EmployeeInfoDAOImpl.
     */
    @Test
    public void testAddEmployeeInfo() throws Exception {
      String id="122";
      em.setEmployeeId(id);
      int i= eid.addEmployeeInfo(em);
      assert(i==1);
      eid.deleteEmployeeInfoById(id);
    }

    /**
     * Test of selectEmployeeInfoById method, of class EmployeeInfoDAOImpl.
     */
    @Test
    public void testSelectEmployeeInfoById() {
        em.setEmployeeId("001");
        eid.addEmployeeInfo(em);
        EmployeeInfo emm=eid.selectEmployeeInfoById(em.getEmployeeId());
        assertEquals(em,emm);
        eid.deleteEmployeeInfoById(em.getEmployeeId());
    }
    
    @Test
    public void testDeletEmployeeInfoById() {
        em.setEmployeeId("001");
        eid.addEmployeeInfo(em);
        eid.deleteEmployeeInfoById(em.getEmployeeId());
        EmployeeInfo ee=eid.selectEmployeeInfoById(em.getEmployeeId());
        assertEquals(null,ee);
    }
}
