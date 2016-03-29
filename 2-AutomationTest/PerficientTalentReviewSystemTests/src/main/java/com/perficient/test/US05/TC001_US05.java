/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US05;


import com.perficient.test.pages.LoginPage;
import com.perficient.test.pages.ScorePage;
import org.testng.annotations.Test;
import com.perficient.test.util.TestCaseBase;
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
    
    @Test
    public static void click() throws InterruptedException{
        PageFactory.initElements(TestCaseBase.driver, sp); 
        PageFactory.initElements(TestCaseBase.driver, lp); 
        driver.navigate().to(URL);
        login("yuhang.zhang","tRApha7T");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/header/div/table/tbody/tr/td[2]/a/b")).click();
        Thread.sleep(2000);
        for(int i=0;i<4;i++){
            driver.findElement(By.xpath("//tr[@id='pmo"+i+"']")).click();
            Thread.sleep(1000);
           for(int j=1;j<4;j++)
            { 
                int r=i+1;
                driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/table/tbody/tr[2]/td[1]")).click();                                         
                Thread.sleep(1000);                    
                driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/div/h[1]/img")).click();
                Thread.sleep(1000);    
                driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/div/h[2]/img")).click();
                Thread.sleep(1000);
            }
        }
        
        for(int i=0;i<4;i++){
           for(int j=1;j<4;j++)
            {
                int r=i+1;
                WebElement select = TestCaseBase.driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/table/tbody/tr[2]/td[1]"));
                Assert.assertNotNull(select,"Fail");
                WebElement select1 = TestCaseBase.driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/div/h[1]/img"));
                Assert.assertNotNull(select1,"Fail");
                WebElement select2 = TestCaseBase.driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/div/h[2]/img"));
                Assert.assertNotNull(select2,"Fail");
                
                Assert.assertEquals(driver.findElement(By.cssSelector("select[disabled]")).getAttribute("disabled"), "true","Fail");
            }
        }
        for(int i=0;i<4;i++){
            driver.findElement(By.xpath("//tr[@id='pmo"+i+"']")).click();
            Thread.sleep(1000);
        } 
        logout();
        Thread.sleep(1000);
        login("young.tao","Weph8zEr");
        sp.clickElement.click();
        driver.findElement(By.xpath("//textarea[@id='E0']")).clear();
        WebElement select=TestCaseBase.driver.findElement(By.xpath("//select[@id='A0']"));
        select.findElement(By.cssSelector("option[label='1']")).click();
        driver.findElement(By.xpath("//textarea[@id='E0']")).sendKeys("He is handsome");
        Thread.sleep(1000);
        sp.clickElement.click();
        logout();
        Thread.sleep(2000);
        login("yuhang.zhang","tRApha7T");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/header/div/table/tbody/tr/td[2]/a/b")).click();
        driver.findElement(By.xpath("//tr[@id='pmo0']")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[1]/form/div[1]/table/tbody/tr[2]/td[1]")).click(); 
        Assert.assertEquals(driver.findElement(By.xpath("//textarea[@id='E0']")).getAttribute("value"),"He is handsome","Fail");
        
        WebElement select2 = TestCaseBase.driver.findElement(By.xpath("//select[@id='A0']"));
        Select select1=new Select(select2);
        String number=select1.getFirstSelectedOption().getText();
        Assert.assertEquals(number, "1","Fail");
        logout();
    }
};
    
    


