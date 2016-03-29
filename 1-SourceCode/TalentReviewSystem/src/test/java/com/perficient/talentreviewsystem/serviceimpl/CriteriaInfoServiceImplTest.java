/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.serviceimpl;

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
public class CriteriaInfoServiceImplTest {
    
    public CriteriaInfoServiceImplTest() {
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
     * Test of getAllCriteria method, of class CriteriaInfoServiceImpl.
     */
    @Test
    public void testGetAllCriteria() {
        CriteriaInfoServiceImpl instance = new CriteriaInfoServiceImpl();
        List<Criteria> result = instance.getAllCriteria();
        assertNotNull(result);
    }
    
}
