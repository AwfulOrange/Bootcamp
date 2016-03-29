/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.talentreviewsystem.entity;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bootcamp19
 */
public class LoginUserTest {
    private String id = "123";
    private String role = "pmo";
    private String sn = "test";
    
    public LoginUserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getScreenName method, of class LoginUser.
     */
    @Test
    public void testGetScreenName() {
        LoginUser instance = new LoginUser();
        instance.setScreenName(sn);
        String expResult = sn;
        String result = instance.getScreenName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setScreenName method, of class LoginUser.
     */
    @Test
    public void testSetScreenName() {
        String screenName = sn;
        LoginUser instance = new LoginUser();
        instance.setScreenName(screenName);
    }

    /**
     * Test of getRole method, of class LoginUser.
     */
    @Test
    public void testGetRole() {
        LoginUser instance = new LoginUser();
        instance.setRole(role);
        String expResult = role;
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRole method, of class LoginUser.
     */
    @Test
    public void testSetRole() {
        LoginUser instance = new LoginUser();
        instance.setRole(role);
    }

    /**
     * Test of getId method, of class LoginUser.
     */
    @Test
    public void testGetId() {
        LoginUser instance = new LoginUser();
        String expResult = id;
        instance.setId(id);
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class LoginUser.
     */
    @Test
    public void testSetId() {
        LoginUser instance = new LoginUser();
        instance.setId(id);
    }
    
}
