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
   
    @FindBy(xpath="/html/body/header/div/table[2]/tbody/tr[1]/th[1]")
    public static WebElement sort0;   
    @FindBy(xpath="/html/body/header/div/table[2]/tbody/tr[1]/th[2]")
    public static WebElement sort1;   
    @FindBy(xpath="/html/body/header/div/table[2]/tbody/tr[1]/th[3]")
    public static WebElement sort2;       
    @FindBy(xpath="/html/body/header/div/table[2]/tbody/tr[1]/th[4]")
    public static WebElement sort3;       
    @FindBy(xpath="/html/body/header/div/table[2]/tbody/tr[1]/th[5]")
    public static WebElement sort4;
    @FindBy(xpath="/html/body/header/div/table[2]/tbody/tr[1]/th[6]")
    public static WebElement sort5;
    
    //********************TC002US06 find Id*********************************************
    @FindBy(xpath="/html/body/header/div/table[2]/tbody/tr[1]/td/input")
    public static WebElement filterbutton;
    @FindBy(id="filter0")
    public static WebElement filter0;
    @FindBy(id="filter1")
    public static WebElement filter1;
    @FindBy(id="filter2")
    public static WebElement filter2;
    @FindBy(id="filter3")
    public static WebElement filter3;
    @FindBy(id="filter4")
    public static WebElement filter4;
    @FindBy(id="filter5")
    public static WebElement filter5;

}
