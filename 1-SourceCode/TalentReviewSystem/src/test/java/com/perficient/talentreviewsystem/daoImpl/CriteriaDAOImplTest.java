/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.daoImpl;

import com.perficient.talentreviewsystem.entity.Criteria;
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
public class CriteriaDAOImplTest {
    CriteriaDAOImpl cdaoi =new CriteriaDAOImpl();
    public CriteriaDAOImplTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testSelectAllCriteria(){
        List<Criteria> lists = cdaoi.selectAllCriteria();
        assert(lists.size()>0);
        System.err.println("testSelectAllCriteria success");
    }
    @Test
    public void testGetCriteriaByLevel(){
        List<Criteria> lists = cdaoi.getCriteriaByLevel("2");
        assert(lists.size()>0);
         System.err.println("GetCriteriaByLevel success");
    }
    @Test
    public void  testGetCriteriaByBoth(){
        List<Criteria> c =cdaoi.getCriteriaByBoth("Achieves Results", "Associate Technical Consultant");
        assert(c.size()>0);
        System.err.println("GetCriteriaBoth success");
    }
}
