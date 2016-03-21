/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.dao.JUnitTest;

import com.perficient.talentreviewsystem.dao.ICriteriaDAO;
import com.perficient.talentreviewsystem.daoImpl.CriteriaDAOImpl;
import com.perficient.talentreviewsystem.entity.Criteria;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bootcamp19
 */
public class ICriteriaDAOTest {
    
    public ICriteriaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of selectAllCriteria method, of class ICriteriaDAO.
     */
    @Test
    public void testSelectAllCriteria() {
        System.out.println("selectAllCriteria");
        ICriteriaDAO instance = new CriteriaDAOImpl();
        List<Criteria> expResult = new ArrayList<Criteria>();
        Criteria cri = new Criteria();
        cri.setId(1);
        cri.setCriteria("Achieves Results");
        cri.setLevel("Associate Technical Consultant");
        cri.setRule("Consistently fails to deliver acceptable results even with support. Unqualified as an Associate Technical Consultant.");
        cri.setScore(1);
        expResult.add(cri);
        Criteria cri1 = new Criteria();
        cri1.setId(2);
        cri1.setCriteria("2");
        cri1.setLevel("2");
        cri1.setRule("2");
        cri1.setScore(2);
        expResult.add(cri1);
        System.out.println(expResult);
        List<Criteria> result = instance.selectAllCriteria();
        System.out.print(result);
        assertEquals(expResult.get(1), result.get(1));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCriteriaByBoth method, of class ICriteriaDAO.
     */
    @Test
    public void testGetCriteriaByBoth() {
        System.out.println("getCriteriaByBoth");
        String criteria = "2";
        String level = "2";
        ICriteriaDAO instance = new CriteriaDAOImpl();
        Criteria expResult = new Criteria();
        expResult.setId(2);
        expResult.setCriteria("2");
        expResult.setLevel("2");
        expResult.setRule("2");
        expResult.setScore(2);
        Criteria result = instance.getCriteriaByBoth(criteria, level);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCriteriaByLevel method, of class ICriteriaDAO.
     */
    @Test
    public void testGetCriteriaByLevel() {
        System.out.println("getCriteriaByLevel");
        String level = "2";
        ICriteriaDAO instance = new CriteriaDAOImpl();
        List<Criteria> expResult = new ArrayList<Criteria>();
        Criteria cri = new Criteria();
        cri.setId(2);
        cri.setCriteria("2");
        cri.setLevel("2");
        cri.setRule("2");
        cri.setScore(2);
        expResult.add(cri);
        List<Criteria> result = instance.getCriteriaByLevel(level);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class ICriteriaDAOImpl implements ICriteriaDAO {

        public List<Criteria> selectAllCriteria() {
            return null;
        }

        public Criteria getCriteriaByBoth(String criteria, String level) {
            return null;
        }

        public List<Criteria> getCriteriaByLevel(String level) {
            return null;
        }
    }
    
}
