/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US05;



import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.perficient.test.util.TestCaseBase;
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
public class TC001_US05 extends TestCaseBase{
    public static final String URL="http://localhost:8080/TRS/page/pmo_leader.jsp";
    
    
    @Test
    public static void click() throws InterruptedException{
       
        
        TestCaseBase.driver.navigate().to(URL);
        Thread.sleep(2000);
        for(int i=0;i<4;i++){
            TestCaseBase.driver.findElement(By.xpath("//tr[@id='pmo"+i+"']")).click();
            Thread.sleep(1000);
           for(int j=1;j<4;j++)
            {   
            int r=i+1;
              TestCaseBase.driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/table/tbody/tr[2]/td[1]")).click();                                         
              Thread.sleep(1000);                    
              TestCaseBase.driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/div/h[1]/img")).click();
                Thread.sleep(1000);                   
              TestCaseBase.driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/div/h[1]/img")).click();
                Thread.sleep(1000);
              TestCaseBase.driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/div/h[2]/img")).click();
                Thread.sleep(1000);
              TestCaseBase.driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/div/h[2]/img")).click();
                Thread.sleep(1000);
              TestCaseBase.driver.findElement(By.xpath("/html/body/div/div/div["+r+"]/form/div["+j+"]/table/tbody/tr[2]/td[1]")).click();
                Thread.sleep(1000);
            }
           TestCaseBase.driver.findElement(By.xpath("//tr[@id='pmo"+i+"']")).click();
           Thread.sleep(2000);
        }
        
//        for(int i=0;i<4;i++){
//           for(int j=1;j<4;j++)
//            {   
//         
//              WebElement select = TestCaseBase.driver.findElement(By.xpath("//select[@id='A0']"));
//            Select select1=new Select(select);
//            String number=select1.getFirstSelectedOption().getText();
//            Assert.assertEquals(number, "1","Fail");
//             
//            }
//           
//        }
        
    }
};
    
    


