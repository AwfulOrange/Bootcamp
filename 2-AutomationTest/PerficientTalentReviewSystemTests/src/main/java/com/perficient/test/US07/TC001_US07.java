/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US07;


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
public class TC001_US07 extends TestCaseBase{
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
        
        int row=driver.findElements(By.xpath("/html/body/header/div/div/table/tbody/tr[2]/td")).size();
        for(int r=0;r<row;r++)
        {
            TestCaseBase.driver.findElement(By.xpath("//tr[@id='pmo"+r+"']")).click();
            Thread.sleep(2000);
            int r1=r+3;
            int row1=driver.findElements(By.xpath("/html/body/header/div/div["+r1+"]/div/div/div/table/tbody/tr[2]/td[1]")).size();
             
            for(int j=0;j<row1;j++)                  
            {
                TestCaseBase.driver.findElement(By.xpath("//tr[@id='revid"+r+""+j+"']")).click();  
                Thread.sleep(2000);                  
                TestCaseBase.driver.findElement(By.xpath("//h[@id='P"+r+""+j+"']")).click();  
                Thread.sleep(2000);    
                TestCaseBase.driver.findElement(By.xpath("//h[@id='S"+r+""+j+"']")).click();  
                Thread.sleep(2000);
                for(int k=65;k<69;k++)
                {
                WebElement select=TestCaseBase.driver.findElement(By.xpath(""));
                select.findElement(By.cssSelector("option[label='5']")).click();
                }
                for(int s=69;s<73;s++)
                {
                TestCaseBase.driver.findElement(By.xpath("")).sendKeys("She is nice!");
                }
            }
        }
   

//        //.............................Assert 1//
     for(int i=0;i<row;i++)
        {
            int r1=i+3;
            int row1=driver.findElements(By.xpath("/html/body/header/div/div["+r1+"]/div/div/div/table/tbody/tr[2]/td[1]")).size();
           
            for(int j=0;j<row1;j++)                  
            {
                for(int k=65;k<69;k++)
                {
                    WebElement select1 = TestCaseBase.driver.findElement(By.xpath(""));
                    Select select2=new Select(select1);
                    String number=select2.getFirstSelectedOption().getText();
                    Assert.assertEquals(number, "5","Fail");   
                }
                for(int s=69;s<73;s++)
                {
                    Assert.assertEquals(TestCaseBase.driver.findElement(By.xpath("")).getAttribute("value"),"NA", "failure"+s);
                }
            }
        }
    }
};

   





