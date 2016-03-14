/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hedyabby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author bootcamp19
 */
public class searchpage {
    @FindBy(id="kw")
    public static WebElement searchElement;
    @FindBy(id="su")
    public static WebElement submitElement;
    
}
