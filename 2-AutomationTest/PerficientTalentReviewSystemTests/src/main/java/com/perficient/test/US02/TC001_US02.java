/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US02;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ScorePage;
import static pages.ScorePage.mouseoverElement1;
import static pages.ScorePage.mouseoverElement2;
import static pages.ScorePage.mouseoverElement3;
import static pages.ScorePage.mouseoverElement4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bootcamp19
 */
public class TC001_US02 {
    public static WebDriver driver; 
    public static final String URL="http://localhost:8080/TRS/page/score.jsp";
    public static ScorePage sp=new ScorePage();
    @BeforeMethod
    public static void setupFirefox() throws Exception{
        driver = new FirefoxDriver();
        PageFactory.initElements(driver, sp);
       
    }
    
//    public static void click(){
//       driver.navigate().to(URL);
//       sp.clickElement.click();
//    }
    @Test
    public static void click() throws InterruptedException{
        driver.navigate().to(URL);
        Thread.sleep(2000);
        sp.clickElement.click();
        Thread.sleep(2000);
        
        Actions action = new Actions(driver);
        action.moveToElement(mouseoverElement1).perform();
        Thread.sleep(2000);
         action.moveToElement(mouseoverElement2).perform();
        Thread.sleep(2000);
         action.moveToElement(mouseoverElement3).perform();
        Thread.sleep(2000);
         action.moveToElement(mouseoverElement4).perform();
        Thread.sleep(2000);

    }
    
   
//     public static void mouseover() throws InterruptedException{
//          //driver.navigate().to(URL);
//       //action.clickAndHold(mouseoverElement);
//      //  WebElement ele = driver.findElement(By.id("AQ0"));
//       
//       //sp.mouseoverElement.click();
//        
//       //  String excepttitle="xxxxxxx";
//        // String truetitle=driver.getTitle();
//        // assertEquals(excepttitle,truetitle);
//     }
    @AfterMethod
     public static void closeFirefox() throws Exception
    {
        driver.quit();
    }
}

