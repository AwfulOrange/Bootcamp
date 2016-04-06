/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.restful;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bootcamp19
 */
public class CriteriaRESTTest {
//    public CriteriaREST CriteriaService;
//    private IMocksControl mockControl;
    
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
//        mockControl = EasyMock.createControl();
//        CriteriaService = mockControl.createMock(CriteriaREST.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCriteria method, of class CriteriaREST.
     */
    @Test
    public void testGetCriteria() throws Exception {
//        HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
//        String lists = null;
//        EasyMock.expect(CriteriaService.getCriteria()).andReturn(lists).once();
//        mockControl.replay();
//        assertEquals(lists, CriteriaService.getCriteria());
//        mockControl.verify();

		URL url = new URL("http://10.2.1.183:8080/TRS/web/cri");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			assertNotNull(output);
		}

		conn.disconnect();
    
    }
    
}
