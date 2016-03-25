/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US01;



import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
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

    
    @Test
    public static void click() throws InterruptedException{
        
        //---------------------1---------------------//
        PageFactory.initElements(TestCaseBase.driver, sp); 
        TestCaseBase.driver.navigate().to(URL);
        Thread.sleep(6000);
        Assert.assertEquals("project", driver.getTitle(),"failure");
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
            WebElement select=TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)r+"0']"));
            for(int j=1;j<6;j++)
            {
                select.findElement(By.cssSelector("option[label='"+Integer.toString(j)+"']")).click();
            }
        }
        for(int s=69;s<73;s++)
        {
            TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']")).sendKeys("NA");
//            Assert.assertNull(driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']")), "failure");
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
       
        sp.click7Element.click();
         for(int s=69;s<73;s++)
        {
                Assert.assertNotEquals(driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']")),"NA", "failure");
        }
          for(int s=69;s<73;s++)
        {
             Assert.assertNotEquals(driver.findElement(By.xpath("//textarea[@id='"+(char)s+"1']")),"NA", "failure");
        }
           for(int s=69;s<73;s++)
        {
             Assert.assertNotEquals(driver.findElement(By.xpath("//textarea[@id='"+(char)s+"2']")),"NA", "failure");
        } 
        Thread.sleep(1000);
//        sp.click10Element.click();
//        Thread.sleep(2000);
        
    };
    
    
}

