/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US02;




import static com.perficient.test.US01.TC001_US01.lp;
import com.perficient.test.pages.LoginPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bootcamp19
 */
public class TC001_US02 extends TestCaseBase{
   // public static WebDriver driver; 
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
   // public static final String URL="http://localhost:8080/TRS/page/score.jsp";
    public static ScorePage sp=new ScorePage();
    public static LoginPage lp = new LoginPage();
   
    @Test
    public static void click() throws InterruptedException{
        TestCaseBase.driver.navigate().to(URL);
        PageFactory.initElements(TestCaseBase.driver, sp); 
        PageFactory.initElements(TestCaseBase.driver,lp);
        login("young.tao","Weph8zEr");
        Thread.sleep(2000);
        //first row
        sp.clickElement.click();
        Thread.sleep(2000);
        WebElement mouseoverElement;
        Actions action = new Actions(TestCaseBase.driver);
        for(int s=73;s<77;s++)
        {
            mouseoverElement=TestCaseBase.driver.findElement(By.xpath("//a[@id='"+(char)s+"0']"));
            action.moveToElement(mouseoverElement).perform();
            Assert.assertNotNull(mouseoverElement, "null");
            Thread.sleep(2000);
        }   
        sp.clickElement.click();
        Thread.sleep(1000);
        
          //second row
        sp.click4Element.click();
        Thread.sleep(2000);
        for(int s=73;s<77;s++)
        {
            mouseoverElement=TestCaseBase.driver.findElement(By.xpath("//a[@id='"+(char)s+"1']"));
            action.moveToElement(mouseoverElement).perform();
            Assert.assertNotNull(mouseoverElement, "null");
            Thread.sleep(2000);
        }   
        sp.click4Element.click();
        Thread.sleep(1000);
          
          //third row
        sp.click7Element.click();
        Thread.sleep(2000);
       
        for(int s=73;s<77;s++)
        {
            mouseoverElement=TestCaseBase.driver.findElement(By.xpath("//a[@id='"+(char)s+"2']"));
            action.moveToElement(mouseoverElement).perform();
            Assert.assertNotNull(mouseoverElement, "null");
            Thread.sleep(2000);
       }
        sp.click7Element.click();
        Thread.sleep(1000);
         
         logout();
      
        
//        action.moveToElement(mouseoverElement1).perform();
//        Thread.sleep(2000);
//        action.moveToElement(mouseoverElement2).perform();
//        Thread.sleep(2000);
//        action.moveToElement(mouseoverElement3).perform();
//        Thread.sleep(2000);
//        action.moveToElement(mouseoverElement4).perform();
        

    }
    

   
}

