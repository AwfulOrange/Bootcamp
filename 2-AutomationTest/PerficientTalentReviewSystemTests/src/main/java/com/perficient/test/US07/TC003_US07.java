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
public class TC003_US07 extends TestCaseBase{
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

        
    //Step1:Click the” PMO-Lead” button
        TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/table/tbody/tr/td[2]/a/b")).click();
        PageFactory.initElements(TestCaseBase.driver, pp);
        Thread.sleep(2000);
    
       
            int row=driver.findElements(By.xpath("/html/body/header/div/div/div/div/div/table/tbody/tr[2]/td[1]")).size();     
            for(int j=0;j<row;j++)                  
            {
    //Step2:Click one reviewee's name
                TestCaseBase.driver.findElement(By.xpath("//tr[@id='revid"+j+"']")).click();  
                Thread.sleep(2000);  
                
    //Step3:Change the scores and comments of the reviewee
                for(int k=65;k<69;k++)
                {
                WebElement select=TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)k+""+j+"']"));
                select.findElement(By.cssSelector("option[label='5']")).click();
                }
                for(int s=69;s<73;s++)
                {
                TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+""+j+"']")).sendKeys("She is nice!");
                } 
                
    //Step4:Click the Approve button
                TestCaseBase.driver.findElement(By.xpath("//button[@id='submitbt"+j+"']")).click();
                
                
    //..................Assert(Approve successfully)....................//
    //All score and comment box as well as the Approve button are disabled//
                WebElement disabled=driver.findElement(By.cssSelector("select[disabled]"));
                Assert.assertEquals(disabled.getAttribute("disabled"), "true","Fail");
            }
            
    //.............Assert(The scores and comments should be modified)......................//         
            for(int j=0;j<row;j++)                  
            {
                for(int k=65;k<69;k++)
                {
                    WebElement select1 = TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)k+""+j+"']"));
                    Select select2=new Select(select1);
                    String number=select2.getFirstSelectedOption().getText();
                    Assert.assertEquals(number, "5","Fail");   
                }
                for(int s=69;s<73;s++)
                {
                    WebElement findcom=TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+""+j+"']"));
                    Assert.assertEquals(findcom.getAttribute("value"),"NA", "failure"+s);
                }
            } 
    
    
    //Step5:Close the talent review page
        logout();
    
    //Step6:Reopen the PMO-leader's page.
        TestCaseBase.driver.navigate().to(URL);
        login("testEM","testEM@gdc");
        Thread.sleep(2000);
        TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/table/tbody/tr/td[2]/a/b")).click();
        PageFactory.initElements(TestCaseBase.driver, pp);
        Thread.sleep(2000);
        
    //Step7:Check the modified data      
            for(int j=0;j<row;j++)                  
            {
                TestCaseBase.driver.findElement(By.xpath("//tr[@id='revid"+j+"']")).click();  
                Thread.sleep(2000);
             }
    
    //.............................Assert .............................//         
            for(int j=0;j<row;j++)                  
            {
                for(int k=65;k<69;k++)
                {
                    WebElement select1 = TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)k+""+j+"']"));
                    Select select2=new Select(select1);
                    String number=select2.getFirstSelectedOption().getText();
                    Assert.assertEquals(number, "5","Fail");   
                }
                for(int s=69;s<73;s++)
                {
                    Assert.assertEquals(TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+""+j+"']")).getAttribute("value"),"NA", "failure"+s);
                }
                WebElement disabled=driver.findElement(By.cssSelector("select[disabled]"));
                Assert.assertEquals(disabled.getAttribute("disabled"), "true","Fail");
            }     
    
    }
};

   





