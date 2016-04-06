/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US04;


import com.perficient.test.pages.LoginPage;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.login;
import static com.perficient.test.util.TestCaseBase.logout;
import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author bootcamp19
 */

/** PMO **/
public class TC002_US04 extends TestCaseBase{
        
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
   //public static final String URL="http://localhost:8080/TRS/page/score.jsp";
    public static LoginPage lp = new LoginPage();
    public static ScorePage sp = new ScorePage();
            
    @Test
    public static void Login() throws Exception{
       TestCaseBase.driver.navigate().to(URL);
       PageFactory.initElements(TestCaseBase.driver, lp); 
       PageFactory.initElements(TestCaseBase.driver, sp); 
       String LoginPagetruetitle = TestCaseBase.driver.getTitle();
       String LoginPageexptitle = "Perficient CAS";
       Assert.assertEquals(LoginPagetruetitle,LoginPageexptitle,"fail");
       login("testEM","testEM@gdc");
       Thread.sleep(2000);
       Assert.assertNotNull(TestCaseBase.driver.findElement(By.linkText("Reviewer")));
       Assert.assertNotNull(TestCaseBase.driver.findElement(By.linkText("PMO-Leader")));
       
       Thread.sleep(2000);
       logout();
       String LoginPagetruetitle1 = TestCaseBase.driver.getTitle();
       String LoginPageexptitle1 = "Perficient CAS";
       assertEquals(LoginPageexptitle1,LoginPagetruetitle1);
        
    }

}
