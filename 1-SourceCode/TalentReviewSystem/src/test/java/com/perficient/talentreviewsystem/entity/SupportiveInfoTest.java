/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.perficient.talentreviewsystem.entity;

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
public class SupportiveInfoTest {
    SupportiveInfo s = new SupportiveInfo();
    String activity="activity";
    String award="award";
    String blog="blog";
    String certification="cerf";
    String coe="coe";
    String culture="cul";
    String recruting="rec";
    String timeEntry="time";
    String training="tri";
    Integer isReviewer=0;
    Integer isPmo=1;
    public SupportiveInfoTest() {
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
    public void testActivity() {
         s = new SupportiveInfo();
        s.setActivity(activity);
        assertEquals(activity,s.getActivity());
    }
    
    
    @Test
    public void testAward() {
        s = new SupportiveInfo();
        s.setAward(award);
        assertEquals(award,s.getAward());
    }
    
    @Test
    public void testBlog() {
        s = new SupportiveInfo();
        s.setBlog(blog);
        assertEquals(blog,s.getBlog());
    }
    
    @Test
    public void testCertification() {
        s = new SupportiveInfo();
        s.setCertification(certification);
        assertEquals(certification,s.getCertification());
    }
    
    @Test
    public void testCoe() {
          s = new SupportiveInfo();
        s.setCoe(coe);
        assertEquals(coe,s.getCoe());
    }
    
    @Test
    public void testCulture() {
          s = new SupportiveInfo();
        s.setCulture(culture);
        assertEquals(culture,s.getCulture());
    }
    
    @Test
    public void testRecruting() {
          s = new SupportiveInfo();
        s.setRecruting(recruting);
        assertEquals(recruting,s.getRecruting());
    }
    
    @Test
    public void testTimeEntry() {
           s = new SupportiveInfo();
        s.setTimeEntry(timeEntry);
        assertEquals(timeEntry,s.getTimeEntry());
    }
    
    @Test
    public void testTraining() {
        s = new SupportiveInfo();
        s.setTraining(training);
        assertEquals(training,s.getTraining());
    }
    
    @Test
    public void testIsReviewer() {
          s = new SupportiveInfo();
        s.setIsReviewer(isReviewer);
        assertEquals(isReviewer,s.getIsReviewer());
    }
    
    @Test
    public void testIsPmo() {
          s = new SupportiveInfo();
        s.setIsPmo(isPmo);
        assertEquals(isPmo,s.getIsPmo());
    }
    
}
