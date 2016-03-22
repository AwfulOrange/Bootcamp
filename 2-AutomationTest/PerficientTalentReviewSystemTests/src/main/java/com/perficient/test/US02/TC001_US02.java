/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US02;




import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.perficient.test.pages.ScorePage;
import static com.perficient.test.pages.ScorePage.mouseoverElement1;
import static com.perficient.test.pages.ScorePage.mouseoverElement2;
import static com.perficient.test.pages.ScorePage.mouseoverElement3;
import static com.perficient.test.pages.ScorePage.mouseoverElement4;
import com.perficient.test.util.TestCaseBase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bootcamp19
 */
public class TC001_US02 extends TestCaseBase{
   // public static WebDriver driver; 
    //public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static final String URL="http://localhost:8080/TRS/page/score.jsp";
    public static ScorePage sp=new ScorePage();
   
    @Test
    public static void click() throws InterruptedException{
         PageFactory.initElements(TestCaseBase.driver, sp); 
        TestCaseBase.driver.navigate().to(URL);
        Thread.sleep(2000);
        sp.clickElement.click();
        Thread.sleep(2000);
        
        Actions action = new Actions(TestCaseBase.driver);
        action.moveToElement(mouseoverElement1).perform();
        Thread.sleep(2000);
         action.moveToElement(mouseoverElement2).perform();
        Thread.sleep(2000);
         action.moveToElement(mouseoverElement3).perform();
        Thread.sleep(2000);
         action.moveToElement(mouseoverElement4).perform();
        Thread.sleep(2000);

    }
    

   
}

