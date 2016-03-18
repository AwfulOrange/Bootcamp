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
    @FindBy(xpath = "/html/body/div/div/form/div[1]/table/tbody/tr[2]/td[1]")
    public static WebElement click1Element;
    
    @FindBy(xpath = "/html/body/div/div/form/div[1]/div/h[1]")
    public static WebElement click2Element;
    
    @FindBy(xpath = "/html/body/div/div/form/div[1]/div/h[2]")
    public static WebElement click3Element;
    
    @FindBy(xpath = "/html/body/div/div/form/div[1]/div/table[3]/tbody/tr[1]/th/select")
    public static WebElement click4Element;
    
    @FindBy(xpath = "/html/body/div/div/form/div[1]/div/table[3]/tbody/tr[2]/th/select")
    public static WebElement click5Element;
    
    @FindBy(xpath = "/html/body/div/div/form/div[1]/div/table[3]/tbody/tr[4]/th/select")
    public static WebElement click6Element;
    
    @FindBy(xpath = "/html/body/div/div/form/div[1]/div/table[3]/tbody/tr[5]/th/select")
    public static WebElement click7Element;
    
    
}
