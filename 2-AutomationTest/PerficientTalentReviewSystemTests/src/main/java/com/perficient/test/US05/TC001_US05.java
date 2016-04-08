/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US05;


import com.perficient.test.pages.LoginPage;
import com.perficient.test.pages.PMOleadPage;
import com.perficient.test.pages.ScorePage;
import org.testng.annotations.Test;
import com.perficient.test.util.TestCaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class TC001_US05 extends TestCaseBase{
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static ScorePage sp = new ScorePage();
    public static LoginPage lp = new LoginPage();
    public static PMOleadPage pp = new PMOleadPage();
    
    @Test
    public static void click() throws InterruptedException{
        PageFactory.initElements(TestCaseBase.driver, sp); 
        PageFactory.initElements(TestCaseBase.driver, lp);
        
        TestCaseBase.driver.navigate().to(URL);
        login("testEM","testEM@gdc");
        Thread.sleep(2000);
        
        TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/table/tbody/tr/td[2]/a/b")).click();
        PageFactory.initElements(TestCaseBase.driver, pp);
        Thread.sleep(2000);
        int row=driver.findElements(By.xpath("/html/body/header/div/div/div/div/div/table/tbody/tr[2]/td[1]")).size();     
        for(int j=0;j<row;j++)
        {
            TestCaseBase.driver.findElement(By.xpath("//tr[@id='revid"+j+"']")).click();  
            Thread.sleep(2000);                  
            driver.findElement(By.xpath("//[@id='P"+j+"']")).click();
            Thread.sleep(2000);    
            driver.findElement(By.xpath("//[@id='S"+j+"']")).click();
            Thread.sleep(2000);
             }
        
        //.............................Assert .........................//
        for(int j=0;j<row;j++)
        {
            WebElement select = TestCaseBase.driver.findElement(By.xpath("//tr[@id='revid"+j+"']"));
            Assert.assertNotNull(select,"Fail");
            Assert.assertEquals(driver.findElement(By.cssSelector("select[disabled]")).getAttribute("disabled"), "true","Fail");
        }
         
        pp.logoutButton.click();


    }
};
    
    


