/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US01;



import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ScorePage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bootcamp19
 */
public class TC001_US01 {
    public static WebDriver driver; 
    public static final String URL="http://localhost:8080/TRS/page/score.jsp";
    public static ScorePage sp=new ScorePage();
 
    @BeforeMethod
    public static void setupFirefox() throws Exception{
        driver = new FirefoxDriver();
        PageFactory.initElements(driver, sp);
       
    }
    
    @Test
    public static void click() throws InterruptedException{
        driver.navigate().to(URL);
        Thread.sleep(2000);
        sp.clickElement.click();
        Thread.sleep(2000);
        sp.click2Element.click(); 
        Thread.sleep(1000);
        sp.click3Element.click(); 
        sp.click4Element.click(); 
        Thread.sleep(1000);
        sp.click5Element.click();   
        Thread.sleep(1000);
        for(int r=65;r<69;r++){
            WebElement select=driver.findElement(By.xpath("//select[@id='"+(char)r+"0']"));
            for(int j=1;j<6;j++)
            {
                select.findElement(By.cssSelector("option[label='"+Integer.toString(j)+"']")).click();
            }
        }
        sp.click6Element.click();
        Thread.sleep(2000);
    }
    
    @AfterMethod
     public static void closeFirefox() throws Exception
    {
        driver.quit();
    }
}

