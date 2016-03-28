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
public class LoginPage {
   @FindBy(id = "username")
    public static WebElement userElement;
    
   @FindBy(id = "password")
   public static WebElement passElement;
    
    @FindBy(xpath = "/html/body/div[1]/div/table/tbody/tr/td[2]/div/form/nobr/button[1]")
    public static WebElement loginButton;
    
    
}
