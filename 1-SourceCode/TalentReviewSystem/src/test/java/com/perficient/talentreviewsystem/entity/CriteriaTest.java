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
    Criteria c = null;
    Integer id=1;
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
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testId() {
       c = new Criteria();
       c.setId(id);
       assertEquals(id,c.getId());
    }

   

   
    @Test
    public void testCriteria() {
        c = new Criteria();
       c.setCriteria(criteria);
       assertEquals(criteria,c.getCriteria());
    }

  

    
    @Test
    public void testLevel() {
       c = new Criteria();
       c.setLevel(level);
       assertEquals(level,c.getLevel());
    }

    @Test
    public void testRule() {
        c = new Criteria();
       c.setRule(rule);
       assertEquals(rule,c.getRule());
    }

    
    @Test
    public void testScore() {
        c = new Criteria();
       c.setScore(score);
       assertEquals(score,c.getScore());
    }

}
