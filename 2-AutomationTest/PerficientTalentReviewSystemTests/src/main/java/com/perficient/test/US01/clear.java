/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US01;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bootcamp19
 */
public class clear extends TestCaseBase{
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static ScorePage sp=new ScorePage();
 
   
    
    @Test
    public static void click() throws InterruptedException{
        
        //---------------------1---------------------//
         TestCaseBase.driver.navigate().to(URL);
        Thread.sleep(2000);
        sp.clickElement.click();
        Thread.sleep(1000);
        for(int s=69;s<73;s++)
        {
             TestCaseBase.driver.findElement(By.xpath("//input[@id='"+(char)s+"0']")).clear();
        }
        sp.clickElement.click();
        Thread.sleep(1000);
        //---------------------2---------------------//
        sp.click4Element.click();
        Thread.sleep(1000);
        for(int s=69;s<73;s++)
        {
             TestCaseBase.driver.findElement(By.xpath("//input[@id='"+(char)s+"1']")).clear();
        }
        sp.click4Element.click();
        Thread.sleep(1000);
        //---------------------3---------------------//
        sp.click7Element.click();   
        Thread.sleep(1000);
        for(int s=69;s<73;s++)
        {
             TestCaseBase.driver.findElement(By.xpath("//input[@id='"+(char)s+"2']")).clear();
        } 
        sp.click7Element.click();
        Thread.sleep(2000);
    
    };
    
    
}

