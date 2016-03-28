/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US01;



import com.perficient.test.pages.LoginPage;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.driver;
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
public class TC001_US01 extends TestCaseBase{
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static ScorePage sp=new ScorePage();
    public static LoginPage lp = new LoginPage();

    
    @Test
    public static void click() throws InterruptedException{
        TestCaseBase.driver.navigate().to(URL);      
        PageFactory.initElements(TestCaseBase.driver,lp);
        login("young.tao","Weph8zEr");
        
        PageFactory.initElements(TestCaseBase.driver, new ScorePage()); 

        Thread.sleep(6000);
        Assert.assertNotNull(driver.getTitle(),"failure");
        
        
        
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
            WebElement select=TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)r+"0']"));
            for(int j=1;j<6;j++)
            {
                select.findElement(By.cssSelector("option[label='"+Integer.toString(j)+"']")).click();
            }
        }
        for(int s=69;s<73;s++)
        {
            TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']")).sendKeys("NA");
        }
       
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
            WebElement select=TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)r+"1']"));
            for(int j=1;j<6;j++)
            {
                select.findElement(By.cssSelector("option[label='"+Integer.toString(j)+"']")).click();
            }
        }
        for(int s=69;s<73;s++)
        {
            TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"1']")).sendKeys("NA");
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
            WebElement select=TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)r+"2']"));
            for(int j=1;j<6;j++)
            {
                select.findElement(By.cssSelector("option[label='"+Integer.toString(j)+"']")).click();
            }
        }
        for(int s=69;s<73;s++)
        {
            TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"2']")).sendKeys("NA");
        } 
       
        ScorePage.click7Element.click();
        Thread.sleep(2000);
         for(int s=69;s<73;s++)
        {
            
            
            Assert.assertEquals(TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']")).getAttribute("value"),"NA", "failure"+s);
        }
          for(int s=69;s<73;s++)
        {
            Assert.assertEquals(TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"1']")).getAttribute("value"),"NA", "failure"+s);
        }
           for(int s=69;s<73;s++)
        {
            Assert.assertEquals(TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"2']")).getAttribute("value"),"NA", "failure"+s);
        } 
        Thread.sleep(1000);
//        sp.click10Element.click();
//        Thread.sleep(2000);
        logout();
        
    };
    
    
}

