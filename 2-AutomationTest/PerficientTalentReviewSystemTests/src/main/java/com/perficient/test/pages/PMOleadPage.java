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
public class PMOleadPage {

    @FindBy(id="pmo2")
    public static WebElement pmo2;

    
    
    @FindBy(id="pmo0")
    public static WebElement pmo0;

    @FindBy(id="revid00")
    public static WebElement revid00;
    
    @FindBy(xpath="/html/body/header/div/div[3]/div/div/div/div/h[1]/img")
    public static WebElement personal00;
    @FindBy(xpath="/html/body/header/div/div[3]/div/div/div/div/h[2]/img")
    public static WebElement supportive00;
    
    @FindBy(id="pmo1")
    public static WebElement pmo1;

    @FindBy(xpath="/html/body/header/div/div[4]/div/div/div/table/tbody/tr[2]/td[1]")
    public static WebElement revid01;
    @FindBy(xpath="/html/body/header/div/div[4]/div/div/div/div/h[1]/img")
    public static WebElement personal01;
    @FindBy(xpath="/html/body/header/div/div[4]/div/div/div/div/h[2]/img")
    public static WebElement supportive01;
    
    
    
    
    
    
//    @FindBy(id="revid1")
//    public static WebElement click4Element;
//    @FindBy(id="P1")
//    public static WebElement click5Element;
//    @FindBy(id="S1")
//    public static WebElement click6Element;
//    
//    @FindBy(id="revid2")
//    public static WebElement click7Element;
//    @FindBy(id="P2")
//    public static WebElement click8Element;
//    @FindBy(id="S2")
//    public static WebElement click9Element;
    
    
    //********************US04 find Id**************************************************
    @FindBy(id="logout")
    public static WebElement logoutButton;
}
