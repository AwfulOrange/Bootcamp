/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author bootcamp19
 */
public class ScorePage {
    @FindBy(id="revid0")
    public static WebElement clickElement;
    @FindBy(id="P0")
    public static WebElement click2Element;
    @FindBy(id="S0")
    public static WebElement click3Element;
    
    @FindBy(id="revid1")
    public static WebElement click4Element;
    @FindBy(id="P1")
    public static WebElement click5Element;
    @FindBy(id="S1")
    public static WebElement click6Element;
    
    @FindBy(id="revid2")
    public static WebElement click7Element;
    @FindBy(id="P2")
    public static WebElement click8Element;
    @FindBy(id="S2")
    public static WebElement click9Element;
    
    @FindBy(id="submitbt")
    public static WebElement click10Element;
    
    //********************US04 find Id**************************************************
    @FindBy(id="logout")
    public static WebElement logoutButton;
     //********************TC001US06 find Id*********************************************
   
    @FindBy(id="xxxxxx")
    public static WebElement sort0;   
    @FindBy(id="xxxxxx")
    public static WebElement sort1;   
    @FindBy(id="xxxxxx")
    public static WebElement sort2;       
    @FindBy(id="xxxxxx")
    public static WebElement sort3;       
    @FindBy(id="xxxxxx")
    public static WebElement sort4;
    
    //********************TC002US06 find Id*********************************************
    @FindBy(id="xxxxxx")
    public static WebElement filter0;
    @FindBy(id="xxxxxx")
    public static WebElement filter1;
    @FindBy(id="xxxxxx")
    public static WebElement filter2;
    @FindBy(id="xxxxxx")
    public static WebElement filter3;
    @FindBy(id="xxxxxx")
    public static WebElement filter4;
    @FindBy(id="xxxxxx")
    public static WebElement filter5;
    @FindBy(id="xxxxxx")
    public static WebElement performancescore;
    @FindBy(id="xxxxxx")
    public static WebElement potentialscore;
    @FindBy(id="xxxxxx")
    public static WebElement totalscore;
}
