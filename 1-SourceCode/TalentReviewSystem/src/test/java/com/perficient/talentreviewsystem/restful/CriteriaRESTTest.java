/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import com.perficient.talentreviewsystem.entity.Criteria;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bootcamp19
 */
public class CriteriaRESTTest {
    public CriteriaREST CriteriaService;
    private IMocksControl mockControl;
    
    public CriteriaRESTTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mockControl = EasyMock.createControl();
        CriteriaService = mockControl.createMock(CriteriaREST.class);
    }
    
    @After
    public void tearDown() {
        CriteriaService = null;
    }

    /**
     * Test of getCriteria method, of class CriteriaREST.
     */
    @Test
    public void testGetCriteria() throws Exception {
        HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
        String lists = null;
        EasyMock.expect(CriteriaService.getCriteria()).andReturn(lists).once();
        mockControl.replay();
        assertEquals(lists, CriteriaService.getCriteria());
        mockControl.verify();
    
    }
    
}
