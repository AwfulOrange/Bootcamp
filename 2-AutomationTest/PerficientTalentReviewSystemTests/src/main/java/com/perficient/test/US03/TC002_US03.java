/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US03;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.driver;
import org.openqa.selenium.By;
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
 
   
    @Test
    public static void click() throws InterruptedException{
         TestCaseBase.driver.navigate().to(URL);
         PageFactory.initElements(TestCaseBase.driver, sp); 
        Thread.sleep(6000);
        for(int s=69;s<73;s++)
        {
            Assert.assertNotEquals(driver.findElement(By.xpath("//textarea[@id='"+(char)s+"0']")),"NANA", "failure");
        }
        sp.clickElement.click();  
        Thread.sleep(3000);
    };
    
}

