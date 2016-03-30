/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US01;



import static com.perficient.test.US01.TC001_US01.lp;
import com.perficient.test.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.driver;
import static com.perficient.test.util.TestCaseBase.login;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
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
public class TC002_US01 extends TestCaseBase{
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static ScorePage sp=new ScorePage();
    public static LoginPage lp = new LoginPage();
    
    @Test
    public static void click() throws InterruptedException{
        //---------------------1---------------------//
        TestCaseBase.driver.navigate().to(URL);
        PageFactory.initElements(TestCaseBase.driver, sp); 
        PageFactory.initElements(TestCaseBase.driver,lp);
       login("testCM","testCM@gdc");
        Thread.sleep(6000);
        
        
        //---------------------C1---------------------//       
        sp.clickElement.click();
        Thread.sleep(1000);
        for(int s=69;s<73;s++)
        {
             TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']")).clear();
        }
        sp.clickElement.click();
        Thread.sleep(1000);
        //---------------------C2---------------------//
        sp.click4Element.click();
        Thread.sleep(1000);
        for(int s=69;s<73;s++)
        {
             TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"1']")).clear();
        }
        sp.click4Element.click();
        Thread.sleep(1000);
        //---------------------C3---------------------//
        sp.click7Element.click();   
        Thread.sleep(1000);
        for(int s=69;s<73;s++)
        {
             TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"2']")).clear();
        } 
        sp.click7Element.click();
        
        
        ScorePage.clickElement.click();
        Thread.sleep(1000);
        ScorePage.click2Element.click(); 
        Thread.sleep(1000);
        ScorePage.click2Element.click(); 
        ScorePage.click3Element.click(); 
        Thread.sleep(1000);
        ScorePage.click3Element.click();   
        Thread.sleep(1000);
        for(int r=65;r<69;r++){
            WebElement select= TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)r+"0']"));
            for(int j=1;j<6;j++)
            {
                select.findElement(By.cssSelector("option[label='"+Integer.toString(j)+"']")).click();
            }
        }
        for(int s=69;s<73;s++)
        {
             TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']")).sendKeys("NA");
        }
        for(int s=69;s<73;s++)
        {
            Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']")).getAttribute("value"),"NA", "failure");
        }
        TestCaseBase.driver.findElement(By.xpath("//textarea[@id='E0']")).clear();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='E0']")).getAttribute("value"),"", "failure");
        Thread.sleep(2000);
        ScorePage.clickElement.click();
        Thread.sleep(1000);
        //---------------------2---------------------//
        ScorePage.click4Element.click();
        Thread.sleep(1000);
        ScorePage.click5Element.click(); 
        Thread.sleep(1000);
        ScorePage.click5Element.click(); 
        ScorePage.click6Element.click(); 
        Thread.sleep(1000);
        ScorePage.click6Element.click();   
        Thread.sleep(1000);
        for(int r=65;r<69;r++){
            WebElement select= TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)r+"1']"));
            for(int j=1;j<6;j++)
            {
                select.findElement(By.cssSelector("option[label='"+Integer.toString(j)+"']")).click();
            }
        }
        for(int s=69;s<73;s++)
        {
             TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"1']")).sendKeys("NA");
        }
        for(int s=69;s<73;s++)
        {
            Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='"+(char)s+"1']")).getAttribute("value"),"NA", "failure");
        }
        ScorePage.click4Element.click();
        Thread.sleep(1000);
        //---------------------3---------------------//
        ScorePage.click7Element.click();
        Thread.sleep(1000);
        ScorePage.click8Element.click(); 
        Thread.sleep(1000);
        ScorePage.click8Element.click(); 
        ScorePage.click9Element.click(); 
        Thread.sleep(1000);
        ScorePage.click9Element.click();   
        Thread.sleep(1000);
        for(int r=65;r<69;r++){
            WebElement select= TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)r+"2']"));
            for(int j=1;j<6;j++)
            {
                select.findElement(By.cssSelector("option[label='"+Integer.toString(j)+"']")).click();
            }
        }
        for(int s=69;s<73;s++)
        {
            TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"2']")).sendKeys("NA");
        }
        for(int s=69;s<73;s++)
        {
            Assert.assertEquals(TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"2']")).getAttribute("value"),"NA", "failure");
        }
        ScorePage.click7Element.click();
        Thread.sleep(1000);
        ScorePage.click10Element.click();

        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertNotNull(message,"Fail to alert");
        alert.accept();

        Thread.sleep(2000);
        logout();
        
    };
    
    
}

