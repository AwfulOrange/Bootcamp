/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author bootcamp19
 */
public class ScorePage {
    @FindBy(id="revid0")
    public static WebElement clickElement;
    @FindBy(xpath = ".//button[ @id='PB0']")
    public static WebElement click2Element;
    @FindBy(xpath = ".//button[ @id='PB0']")
    public static WebElement click3Element;
    @FindBy(id="SB0")
    public static WebElement click4Element;
    @FindBy(id="SB0")
    public static WebElement click5Element;
    @FindBy(id="A0")
    public static WebElement click6Element;
    @FindBy(xpath=".//a[@id='AQ0']")
    public static WebElement mouseoverElement1;
    @FindBy(xpath=".//a[@id='OQ0}']")
    public static WebElement mouseoverElement2;
    @FindBy(xpath=".//a[@id='LQ0']")
    public static WebElement mouseoverElement3;
    @FindBy(xpath=".//a[@id='VQ0']")
    public static WebElement mouseoverElement4;
    

}