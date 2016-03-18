/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US02;




import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CriteriaPage;
import static pages.CriteriaPage.mouseoverElement;

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
    public static CriteriaPage cri=new CriteriaPage();
    @BeforeMethod
    public static void setupFirefox() throws Exception{
        driver = new FirefoxDriver();
        PageFactory.initElements(driver, cri);
    
       
    }
    @Test
    public static void mouseover(){
        
        driver.navigate().to(URL);
        Actions action = new Actions(driver);
       action.moveToElement(mouseoverElement);
      //  String excepttitle="xxxxxxx";
       // String truetitle=driver.getTitle();
       // assertEquals(excepttitle,truetitle);
    }
    @AfterMethod
     public static void closeFirefox() throws Exception
    {
        driver.quit();
    }
}

