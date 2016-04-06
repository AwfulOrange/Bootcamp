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
       String a = e.getId();
       assertEquals(id,a);
    }


    @Test
    public void testType() {
       e = new Employee();
       e.setType(type);
       String a = e.getType();
       assertEquals(type,a);
    }

    @Test
    public void testRole() {
       e = new Employee();
       e.setRole(role);
       String a = e.getRole();
       assertEquals(role,a);
    }


    @Test
    public void testTitle() {
       e = new Employee();
       e.setTitle(title);
       String a = e.getTitle();
       assertEquals(title,a);
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
       String a = e.getFirstName();
       assertEquals(firstName,a);
    }

    @Test
    public void testLastName() {
       e = new Employee();
       e.setLastName(lastName);
       String a = e.getLastName();
       assertEquals(lastName,a);
    }

    @Test
    public void testScreenName() {
        e = new Employee();
       e.setScreenName(screenName);
       String a = e.getScreenName();
       assertEquals(screenName,a);
    }

    @Test
    public void testGender() {
         e = new Employee();
       e.setGender(gender);
       String a = e.getGender();
       assertEquals(gender,a);
    }

    @Test
    public void testEmid() {
        e = new Employee();
       e.setEmid(emid);
       String a = e.getEmid();
       assertEquals(emid,a);
    }


    @Test
    public void testLastUpdated() {
        e = new Employee();
       e.setLastUpdated(lastUpdated);
       String a = e.getLastUpdated();
       assertEquals(lastUpdated,a);
    }

    @Test
    public void testOnBoardDate() {
        e = new Employee();
       e.setOnBoardDate(onBoardDate);
       String a = e.getOnBoardDate();
       assertEquals(onBoardDate,a);
    }

    @Test
    public void testPhotoURL() {
         e = new Employee();
       e.setPhotoURL(photoURL);
       String a = e.getPhotoURL();
       assertEquals(photoURL,a);
    }


    @Test
    public void testBu() {
        e = new Employee();
       e.setBu(bu);
       String a = e.getBu();
       assertEquals(bu,a);
    }

    @Test
    public void testWorkStartDate() {
        e = new Employee();
       e.setWorkStartDate(workStartDate);
       String a = e.getWorkStartDate();
       assertEquals(workStartDate,a);
    }

    @Test
    public void testLineManager() {
        e = new Employee();
       e.setLineManager(lineManager);
       String a = e.getLineManager();
       assertEquals(lineManager,a);
    }

    @Test
    public void testLastDay() {
       e = new Employee();
       e.setLastDay(lastDay);
       String a = e.getLastDay();
       assertEquals(lastDay,a);
    }

    @Test
    public void testDepartment() {
        e = new Employee();
       e.setDepartment(department);
       String a = e.getDepartment();
       assertEquals(department,a);
    }

    @Test
    public void testGdcStartDate() {
         e = new Employee();
       e.setGdcStartDate(gdcStartDate);
       String a = e.getGdcStartDate();
       assertEquals(gdcStartDate,a);
    }

    @Test
    public void testLastPromotionDate() {
        e = new Employee();
       e.setLastPromotionDate(lastPromotionDate);
       String a = e.getLastPromotionDate();
       assertEquals(lastPromotionDate,a);
    }

    @Test
    public void testStartLevel() {
        e = new Employee();
       e.setStartLevel(startLevel);
       String a = e.getStartLevel();
       assertEquals(startLevel,a);
    }


    @Test
    public void testScore() {
        e = new Employee();
       e.setScore(Score);
       TalentReviewScore a = e.getScore();
       assertEquals(Score,a);
    }

    
}
