/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US03;

import static com.perficient.test.US02.TC001_US02.sp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import org.openqa.selenium.support.PageFactory;




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
    public static ScorePage sp=new ScorePage();
 
    
    
    @Test
    public static void click() throws InterruptedException{
         TestCaseBase.driver.navigate().to(URL);
         PageFactory.initElements(TestCaseBase.driver, sp); 
        Thread.sleep(6000);
        sp.clickElement.click();  
        Thread.sleep(1000);
        for(int r=65;r<69;r++){
            WebElement select= TestCaseBase.driver.findElement(By.xpath("//select[@id='"+(char)r+"0']"));
            
                select.findElement(By.cssSelector("option[label='1']")).click();
            
        }
        for(int s=69;s<73;s++)
        {
             TestCaseBase.driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']")).sendKeys("NA");
        }
        Thread.sleep(2000);
        sp.clickElement.click();
         Thread.sleep(1000); 
        sp.click10Element.click();
         Thread.sleep(2000);
        
    };
    
    
}

