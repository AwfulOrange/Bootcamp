/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

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
public class EmployeeRESTTest {

    public EmployeeREST employeeRest;
    private IMocksControl mockControl;

    public EmployeeRESTTest() {
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
        employeeRest = mockControl.createMock(EmployeeREST.class);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findByPMOID method, of class EmployeeREST.
     */
    @Test
    public void testFindByPMOID() throws Exception {
        String pmoId = "212";
        String jsonStr = "";
        EasyMock.expect(employeeRest.findByPMOID(pmoId)).andReturn(jsonStr).once();
        mockControl.replay();
        assertEquals(jsonStr, employeeRest.findByPMOID(pmoId));
        mockControl.verify();
    }

    /**
     * Test of findByReviewID method, of class EmployeeREST.
     */
    @Test
    public void testFindByReviewID() throws Exception {
        String reviewerId = "1812";
        String jsonStr = "";
        EasyMock.expect(employeeRest.findByReviewID(reviewerId)).andReturn(jsonStr).once();
        mockControl.replay();
        assertEquals(jsonStr, employeeRest.findByReviewID(reviewerId));
        mockControl.verify();
    }

}
