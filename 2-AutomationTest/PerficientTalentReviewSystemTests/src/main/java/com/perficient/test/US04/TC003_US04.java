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
import org.testng.annotations.Test;

/**
 *
 * @author bootcamp19
 */
public class TC003_US04 extends TestCaseBase{
        
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
  // public static final String URL="http://localhost:8080/TRS/page/score.jsp";
    public static LoginPage lp = new LoginPage();
    public static ScorePage sp = new ScorePage();
            
    @Test
    public static void Login() throws Exception{
       login("","");
       Thread.sleep(2000);
       String ScorePagetruetitle = TestCaseBase.driver.getTitle();
       String ScorePageexptitle = "xxxxxxxxxxxx";
       assertEquals(ScorePageexptitle,ScorePagetruetitle);
       
       Thread.sleep(2000);
       logout();
       String LoginPagetruetitle = TestCaseBase.driver.getTitle();
       String LoginPageexptitle = "xxxxxxxxxxxx";
       assertEquals(LoginPageexptitle,LoginPagetruetitle);
        
    }

}
