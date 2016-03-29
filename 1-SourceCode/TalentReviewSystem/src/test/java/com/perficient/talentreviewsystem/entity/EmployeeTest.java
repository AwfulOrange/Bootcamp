/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import java.util.Collection;
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
public class EmployeeTest {
    Employee e = new Employee();
     String id ="1";
     String type="type";
     String role="role";
     String title="title";
     boolean active=true;
     String firstName="fn";
     String lastName="ln";
     String screenName="sn";
     String gender="gender";
     String emid="1";
     String lastUpdated="lu";
     String onBoardDate="abd";
     String photoURL="url";
     String bu="bu";
     String workStartDate="2016-3-2";
     String lineManager="lm";
     String lastDay="lastdate";
     String department="dm";
     String gdcStartDate="startdate";
     String lastPromotionDate="lpd";
     String startLevel="startlevel";
     Collection<SupportiveInfo> supportiveInfoCollection;
     TalentReviewScore Score;
     
    public EmployeeTest() {
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
    public void testId() {
       e = new Employee();
       e.setId(id);
       assertEquals(id,e.getId());
    }


    @Test
    public void testType() {
       e = new Employee();
       e.setType(type);
       assertEquals(type,e.getType());
    }

    @Test
    public void testRole() {
         e = new Employee();
       e.setRole(role);
       assertEquals(role,e.getRole());
    }


    @Test
    public void testTitle() {
       e = new Employee();
       e.setTitle(title);
       assertEquals(title,e.getTitle());
    }

    @Test
    public void testIsActive() {
       e = new Employee();
       e.setActive(active);
       assertEquals(active,true);
    }

   

    @Test
    public void testFirstName() {
        e = new Employee();
       e.setFirstName(firstName);
       assertEquals(firstName,e.getFirstName());
    }

    @Test
    public void testLastName() {
       e = new Employee();
       e.setLastName(lastName);
       assertEquals(lastName,e.getLastName());
    }

    @Test
    public void testScreenName() {
        e = new Employee();
       e.setScreenName(screenName);
       assertEquals(screenName,e.getScreenName());
    }

    @Test
    public void testGender() {
         e = new Employee();
       e.setGender(gender);
       assertEquals(gender,e.getGender());
    }

    @Test
    public void testEmid() {
        e = new Employee();
       e.setEmid(emid);
       assertEquals(emid,e.getEmid());
    }


    @Test
    public void testLastUpdated() {
        e = new Employee();
       e.setLastUpdated(lastUpdated);
       assertEquals(lastUpdated,e.getLastUpdated());
    }

    @Test
    public void testOnBoardDate() {
        e = new Employee();
       e.setOnBoardDate(onBoardDate);
       assertEquals(onBoardDate,e.getOnBoardDate());
    }

    @Test
    public void testPhotoURL() {
         e = new Employee();
       e.setPhotoURL(photoURL);
       assertEquals(photoURL,e.getPhotoURL());
    }


    @Test
    public void testBu() {
        e = new Employee();
       e.setBu(bu);
       assertEquals(bu,e.getBu());
    }

    @Test
    public void testWorkStartDate() {
        e = new Employee();
       e.setWorkStartDate(workStartDate);
       assertEquals(workStartDate,e.getWorkStartDate());
    }

    @Test
    public void testLineManager() {
        e = new Employee();
       e.setLineManager(lineManager);
       assertEquals(lineManager,e.getLineManager());
    }

    @Test
    public void testLastDay() {
       e = new Employee();
       e.setLastDay(lastDay);
       assertEquals(lastDay,e.getLastDay());
    }

    @Test
    public void testDepartment() {
        e = new Employee();
       e.setDepartment(department);
       assertEquals(department,e.getDepartment());
    }

    @Test
    public void testGdcStartDate() {
         e = new Employee();
       e.setGdcStartDate(gdcStartDate);
       assertEquals(gdcStartDate,e.getGdcStartDate());
    }

    @Test
    public void testLastPromotionDate() {
        e = new Employee();
       e.setLastPromotionDate(lastPromotionDate);
       assertEquals(lastPromotionDate,e.getLastPromotionDate());
    }

    @Test
    public void testStartLevel() {
        e = new Employee();
       e.setStartLevel(startLevel);
       assertEquals(startLevel,e.getStartLevel());
    }


    @Test
    public void testScore() {
        e = new Employee();
       e.setScore(Score);
       assertEquals(Score,e.getScore());
    }

    
}
