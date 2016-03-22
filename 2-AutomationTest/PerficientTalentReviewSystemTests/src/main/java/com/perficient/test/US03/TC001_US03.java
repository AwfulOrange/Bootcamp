/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
public class TC001_US03 {
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
        Thread.sleep(1000);
        for(int r=65;r<69;r++){
            WebElement select=driver.findElement(By.xpath("//select[@id='"+(char)r+"0']"));
            
                select.findElement(By.cssSelector("option[label='1']")).click();
            
        }
        for(int s=69;s<73;s++)
        {
            driver.findElement(By.xpath("//input[@id='"+(char)s+"0']")).sendKeys("NA");
        }
        Thread.sleep(2000);
        sp.clickElement.click();
        
    };
    
    @AfterMethod
     public static void closeFirefox() throws Exception
    {
        driver.quit();
    }
}

