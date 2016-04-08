/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US05;

import com.perficient.test.pages.LoginPage;
import com.perficient.test.pages.PMOleadPage;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.login;
import static com.perficient.test.util.TestCaseBase.logout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author bootcamp19
 */
public class TC002_US05 extends TestCaseBase{
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static ScorePage sp = new ScorePage();
    public static LoginPage lp = new LoginPage();
    public static PMOleadPage pp = new PMOleadPage();
    
    @Test
    public static void click() throws InterruptedException{
        
        PageFactory.initElements(TestCaseBase.driver, sp); 
        PageFactory.initElements(TestCaseBase.driver, lp);
      
        TestCaseBase.driver.navigate().to(URL);
        ModifyInfo();
        
       Thread.sleep(3000);
        login("testEM","testEM@gdc");
        Thread.sleep(2000);
        PageFactory.initElements(TestCaseBase.driver, pp);
        TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/table/tbody/tr/td[2]/a/b")).click();
        Thread.sleep(4000);
        pp.revid00.click(); 
        Thread.sleep(4000);
        Assert.assertEquals(TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/div[5]/div/div/div[1]/div/table[3]/tbody/tr[2]/td[3]/textarea")).getAttribute("value"),"He is handsome","Fail");
        WebElement select2 = TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/div[5]/div/div/div[1]/div/table[3]/tbody/tr[2]/td[2]/select"));
        Select select1=new Select(select2);
        String number=select1.getFirstSelectedOption().getText();
        Assert.assertEquals(number, "2","Fail");
        logout();  
    }
    
    public static void ModifyInfo() throws InterruptedException{
        login("testCM","testCM@gdc");
        Thread.sleep(3000);
        sp.clickElement.click();
        TestCaseBase.driver.findElement(By.xpath("//textarea[@id='E0']")).clear();
        WebElement select=TestCaseBase.driver.findElement(By.xpath("//select[@id='A0']"));
        select.findElement(By.cssSelector("option[label='2']")).click();
        TestCaseBase.driver.findElement(By.xpath("//textarea[@id='E0']")).sendKeys("He is handsome");
        Thread.sleep(2000);
        sp.clickElement.click();
         Thread.sleep(2000);
        logout();
        
    }
}
