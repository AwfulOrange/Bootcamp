/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US03;


import static com.perficient.test.US01.TC001_US01.lp;
import com.perficient.test.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class TC002_US03 extends TestCaseBase{
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static ScorePage sp=new ScorePage();
    public static LoginPage lp = new LoginPage();
 
   
    @Test
    public static void click() throws InterruptedException{
         TestCaseBase.driver.navigate().to(URL);
         PageFactory.initElements(TestCaseBase.driver,lp);
         login("young.tao","Weph8zEr");
         PageFactory.initElements(TestCaseBase.driver, sp); 
         Thread.sleep(6000);
         sp.clickElement.click(); 
         Thread.sleep(2000);

            WebElement select = TestCaseBase.driver.findElement(By.xpath("//select[@id='A0']"));
            Select select1=new Select(select);
            String number=select1.getFirstSelectedOption().getText();
            Assert.assertEquals(number, "1","Fail");
            
            WebElement select2 = TestCaseBase.driver.findElement(By.xpath("//select[@id='B0']"));
            Select select12=new Select(select2);
            String number2=select12.getFirstSelectedOption().getText();
            Assert.assertEquals(number2, "1","Fail");
 
            WebElement select3 = TestCaseBase.driver.findElement(By.xpath("//select[@id='C0']"));
            Select select13=new Select(select3);
            String number3=select13.getFirstSelectedOption().getText();
            Assert.assertEquals(number3, "1","Fail");

            WebElement select4 = TestCaseBase.driver.findElement(By.xpath("//select[@id='D0']"));
            Select select14=new Select(select4);
            String number4=select14.getFirstSelectedOption().getText();
            Assert.assertEquals(number4, "1","Fail");
            
        for(int s=69;s<73;s++)
        {
            WebElement we=TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']"));
            Assert.assertEquals(we.getAttribute("value"), "NA","Fail to Match");
        }
           
            

        Thread.sleep(1000);
        logout();
    };
    
}

