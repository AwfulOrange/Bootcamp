/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US03;

import static com.perficient.test.US01.TC001_US01.lp;
import static com.perficient.test.US02.TC001_US02.sp;
import com.perficient.test.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.login;
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
public class TC001_US03 extends TestCaseBase{
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static LoginPage lp = new LoginPage();
    
    
    @Test
    public static void click() throws InterruptedException{
         TestCaseBase.driver.navigate().to(URL);
        PageFactory.initElements(TestCaseBase.driver,lp);
        login("young.tao","Weph8zEr");
         PageFactory.initElements(TestCaseBase.driver, sp); 
        Thread.sleep(6000);
        ScorePage.clickElement.click();  
        Thread.sleep(2000);
        for(int r=65;r<69;r++){
            WebElement select= TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)r+"0']"));
            select.findElement(By.cssSelector("option[label='1']")).click();
            Select select1=new Select(select);
            String number=select1.getFirstSelectedOption().getText();
            Assert.assertEquals(number, "1","Fail");
                
            
        }
        for(int s=69;s<73;s++)
        {
            WebElement we=TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']"));
            we.clear();
            we.sendKeys("NA");
        }
        Thread.sleep(2000);
        ScorePage.clickElement.click();
         Thread.sleep(1000); 
         
         logout();
        
    };
    
    
}

