/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

//import java.util.Collection;
import java.util.Date;
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
public class EmployeeInfoTest {
    EmployeeInfo ei = new EmployeeInfo();
    String employeeId="1";
    String department="dep";
    Date gdcStartDate=new Date();
    Date lastPromotionDate =new Date(2016,3,28);
    String startLevel="startLevel";
    Date workStartDate=new Date(2016,3,28);
    public EmployeeInfoTest() {
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
    public void testEmployeeId() {
        ei= new EmployeeInfo();
        ei.setEmployeeId(employeeId);
        assertEquals(employeeId,ei.getEmployeeId());
    }


    @Test
    public void testDepartment() {
      ei= new EmployeeInfo();
      ei.setDepartment(department);
      assertEquals(department,ei.getDepartment());
    }

    @Test
    public void testGdcStartDate() {
        ei= new EmployeeInfo();
      ei.setGdcStartDate(gdcStartDate);
      assertEquals(gdcStartDate,ei.getGdcStartDate());
    }

    @Test
    public void testLastPromotionDate() {
         ei= new EmployeeInfo();
      ei.setLastPromotionDate(lastPromotionDate);
      assertEquals(lastPromotionDate,ei.getLastPromotionDate());
    }

    @Test
    public void testStartLevel() {
         ei= new EmployeeInfo();
      ei.setStartLevel(startLevel);
      assertEquals(startLevel,ei.getStartLevel());
    }

    @Test
    public void testWorkStartDate() {
        ei= new EmployeeInfo();
      ei.setWorkStartDate(workStartDate);
      assertEquals(workStartDate,ei.getWorkStartDate());
    }

    
}
