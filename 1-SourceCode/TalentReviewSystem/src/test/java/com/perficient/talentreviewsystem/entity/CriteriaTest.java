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
public class CriteriaTest {
    Cri c = new Cri();
    Integer id=1;
    Cri c1 = new Cri(id);
    String criteria="criteria";
    String level="level";
    String rule="rule";
    Integer score=4;
    
    public CriteriaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        c.setId(id);
        c.setCriteria(criteria);
        c.setLevel(level);
        c.setRule(rule);
        c.setScore(score);
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testId() {
       assertEquals(id,c.getId());
    }

   

   
    @Test
    public void testCri() {
       assertEquals(criteria,c.getCriteria());
    }

  

    
    @Test
    public void testLevel() {
       assertEquals(level,c.getLevel());
    }

    @Test
    public void testRule() {
       assertEquals(rule,c.getRule());
    }
    
    @Test
    public void testScore() {
       assertEquals(score,c.getScore());
    }
    
    @Test
    public void testHashCode() {
        assertNotNull(c.hashCode());
    }
    
    @Test
    public void testEquals() {
        assertTrue(c.equals(c));
    }
    
    @Test
    public void testToString() {
        String str = c.toString();        
        String a = "com.perficient.talentreviewsystem.entity.Cri[ id=1 ]";
        assertEquals(a, str);
    }

}
