/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceimpl;

import com.perficient.talentreviewsystem.entity.Employee;
import com.perficient.talentreviewsystem.entity.Group;
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class EmployeeInfoServiceImpl.
     */
    @Test
    public void findAllByReviewerID() {
        EmployeeInfoServiceImpl instance = new EmployeeInfoServiceImpl();
        List<Employee> result1 = instance.findAllByReviewerID("3");
       
        assertNotNull(result1);
       
        //fail("The test case is a prototype.");
    }
    @Test
    public void findAllByPMOID() {
        EmployeeInfoServiceImpl instance = new EmployeeInfoServiceImpl();
        List<Group> result2=instance.findAllByPMOID("664");
        assertNotNull(result2);
    }

    /**
     * Test of findAllByReviewerID method, of class EmployeeInfoServiceImpl.
     */
    @Test
    public void testFindAllByReviewerID() {
        System.out.println("findAllByReviewerID");
        String reviewerid = "";
        EmployeeInfoServiceImpl instance = new EmployeeInfoServiceImpl();
        List<Employee> expResult = null;
        List<Employee> result = instance.findAllByReviewerID(reviewerid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllByPMOID method, of class EmployeeInfoServiceImpl.
     */
    @Test
    public void testFindAllByPMOID() {
        System.out.println("findAllByPMOID");
        String pmoid = "";
        EmployeeInfoServiceImpl instance = new EmployeeInfoServiceImpl();
        List<Group> expResult = null;
        List<Group> result = instance.findAllByPMOID(pmoid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
