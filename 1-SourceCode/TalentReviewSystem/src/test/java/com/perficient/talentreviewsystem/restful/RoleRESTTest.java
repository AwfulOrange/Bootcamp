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
public class RoleRESTTest {
    public RoleREST RoleRest;
    private IMocksControl mockControl;
 
    public RoleRESTTest(){
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
        RoleRest = mockControl.createMock(RoleREST.class);
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetLoginUser() throws Exception {
        String jsonstr= "";
        EasyMock.expect(RoleRest.getLoginUser()).andReturn(jsonstr).once();
        mockControl.replay();
        assertEquals(jsonstr, RoleRest.getLoginUser());
        mockControl.verify();
    }  
}
