/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US01;


import static com.perficient.test.US02.US01_TC001.driver;
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
        //---------------------1---------------------//
        driver.navigate().to(URL);
        Thread.sleep(2000);
        sp.clickElement.click();
        Thread.sleep(1000);
        sp.click2Element.click(); 
        Thread.sleep(1000);
        sp.click2Element.click(); 
        sp.click3Element.click(); 
        Thread.sleep(1000);
        sp.click3Element.click();   
        Thread.sleep(1000);
        for(int r=65;r<69;r++){
            WebElement select=driver.findElement(By.xpath("//select[@id='"+(char)r+"0']"));
            for(int j=1;j<6;j++)
            {
                select.findElement(By.cssSelector("option[label='"+Integer.toString(j)+"']")).click();
            }
        }
        for(int s=69;s<73;s++)
        {
            driver.findElement(By.xpath("//input[@id='"+(char)s+"0']")).sendKeys("NA");
        }
        sp.clickElement.click();
        Thread.sleep(1000);
        //---------------------2---------------------//
        sp.click4Element.click();
        Thread.sleep(1000);
        sp.click5Element.click(); 
        Thread.sleep(1000);
        sp.click5Element.click(); 
        sp.click6Element.click(); 
        Thread.sleep(1000);
        sp.click6Element.click();   
        Thread.sleep(1000);
        for(int r=65;r<69;r++){
            WebElement select=driver.findElement(By.xpath("//select[@id='"+(char)r+"1']"));
            for(int j=1;j<6;j++)
            {
                select.findElement(By.cssSelector("option[label='"+Integer.toString(j)+"']")).click();
            }
        }
        for(int s=69;s<73;s++)
        {
            driver.findElement(By.xpath("//input[@id='"+(char)s+"1']")).sendKeys("NA");
        }
        sp.click4Element.click();
        Thread.sleep(1000);
        //---------------------3---------------------//
        sp.click7Element.click();
        Thread.sleep(1000);
        sp.click8Element.click(); 
        Thread.sleep(1000);
        sp.click8Element.click(); 
        sp.click9Element.click(); 
        Thread.sleep(1000);
        sp.click9Element.click();   
        Thread.sleep(1000);
        for(int r=65;r<69;r++){
            WebElement select=driver.findElement(By.xpath("//select[@id='"+(char)r+"2']"));
            for(int j=1;j<6;j++)
            {
                select.findElement(By.cssSelector("option[label='"+Integer.toString(j)+"']")).click();
            }
        }
        for(int s=69;s<73;s++)
        {
            driver.findElement(By.xpath("//input[@id='"+(char)s+"2']")).sendKeys("NA");
        } 
        sp.click7Element.click();
        Thread.sleep(1000);
        sp.click10Element.click();
        Thread.sleep(2000);
    };
    
    @AfterMethod
     public static void closeFirefox() throws Exception
    {
        driver.quit();
    }
}

