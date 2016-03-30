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
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
        pp.pmo0.click();
        Thread.sleep(2000);
        pp.revid00.click();
        Thread.sleep(2000);
        pp.personal00.click(); 
        Thread.sleep(2000);
        pp.supportive00.click();
        pp.pmo1.click();
        Thread.sleep(2000);
        pp.revid01.click();
        Thread.sleep(2000);
        pp.personal01.click(); 
        Thread.sleep(2000);
        pp.supportive01.click();
////
////
////        List<WebElement> columnElements = driver.findElements(By.cssSelector("tr"));
////         int rowNumber = columnElements.size();
////         System.out.println("---------------------"+rowNumber);
//
            pp.pmo2.click();
           Thread.sleep(5000);
           for(int j=1;j<4;j++)
           { 
               driver.findElement(By.xpath("/html/body/header/div/div[5]/div/div/div["+j+"]/table/tbody/tr[2]/td[1]")).click();   
               Thread.sleep(2000);                  
               driver.findElement(By.xpath("/html/body/header/div/div[5]/div/div/div["+j+"]/div/h[1]/img")).click();
               Thread.sleep(2000);    
               driver.findElement(By.xpath("/html/body/header/div/div[5]/div/div/div["+j+"]/div/h[2]/img")).click();
               Thread.sleep(2000);
             }
        //.............................Assert 1//
         for(int j=1;j<2;j++){
                 int r=3;
                 WebElement select = TestCaseBase.driver.findElement(By.xpath(" /html/body/header/div/div["+r+"]/div/div/div["+j+"]/table/tbody/tr[2]/td[1]"));
                 Assert.assertNotNull(select,"Fail");
                 WebElement select1 = TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/div["+r+"]/div/div/div["+j+"]/div/h[1]/img"));
                 Assert.assertNotNull(select1,"Fail");
                 WebElement select2 = TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/div["+r+"]/div/div/div["+j+"]/div/h[2]/img"));
                 Assert.assertNotNull(select2,"Fail");
                Assert.assertEquals(driver.findElement(By.cssSelector("select[disabled]")).getAttribute("disabled"), "true","Fail");
             }
         
        //.............................Assert 2//
         for(int j=1;j<2;j++)
             {
                 int r=4;
         WebElement select3= TestCaseBase.driver.findElement(By.xpath(" /html/body/header/div/div["+r+"]/div/div/div["+j+"]/table/tbody/tr[2]/td[1]"));
                 Assert.assertNotNull(select3,"Fail");
                WebElement select4= TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/div["+r+"]/div/div/div["+j+"]/div/h[1]/img"));
                  Assert.assertNotNull(select4,"Fail");
                 WebElement select5= TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/div["+r+"]/div/div/div["+j+"]/div/h[2]/img"));
                 Assert.assertNotNull(select5,"Fail");
                 Assert.assertEquals(driver.findElement(By.cssSelector("select[disabled]")).getAttribute("disabled"), "true","Fail");
             }
         
        //.............................Assert 3//
            for(int j=1;j<4;j++)
             {
                 int r=5;
                 WebElement select6= TestCaseBase.driver.findElement(By.xpath(" /html/body/header/div/div["+r+"]/div/div/div["+j+"]/table/tbody/tr[2]/td[1]"));
                 Assert.assertNotNull(select6,"Fail");
                 WebElement select7 = TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/div["+r+"]/div/div/div["+j+"]/div/h[1]/img"));
                 Assert.assertNotNull(select7,"Fail");
                 WebElement select8 = TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/div["+r+"]/div/div/div["+j+"]/div/h[2]/img"));
                 Assert.assertNotNull(select8,"Fail");
             }
       
        
        pp.logoutButton.click();


    }
};
    
    


