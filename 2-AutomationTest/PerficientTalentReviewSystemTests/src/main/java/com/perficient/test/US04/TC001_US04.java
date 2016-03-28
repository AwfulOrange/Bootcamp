/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US04;

import com.perficient.test.pages.LoginPage;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author bootcamp19
 */



/** Reviewer **/
public class TC001_US04 extends TestCaseBase{
        
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
  // public static final String URL="http://localhost:8080/TRS/page/score.jsp";
    public static LoginPage lp = new LoginPage();
    public static ScorePage sp = new ScorePage();
    
      public static boolean CheckTab(){
        boolean flag = false;
        if(TestCaseBase.driver.findElement(By.id("pmotab"))==null){
            flag = true;
        }
        return flag;    
    }
            
    @Test
    public static void Login() throws Exception{
       String LoginPagetruetitle = TestCaseBase.driver.getTitle();
       String LoginPageexptitle = "Perficient CAS";
       Assert.assertEquals(LoginPageexptitle,LoginPagetruetitle,"fail to redirect");        
       login("young.tao","Weph8zEr");
       Thread.sleep(2000);
       boolean f = CheckTab();
       Assert.assertTrue(f);
       Assert.assertEquals(TestCaseBase.driver.findElement(By.id("scoretab")).getAttribute("value"),"Score","1");
       
       Thread.sleep(2000);
       logout();
       String LoginPagetruetitle1 = TestCaseBase.driver.getTitle();
       String LoginPageexptitle1 = "Perficient CAS";
       Assert.assertEquals(LoginPageexptitle1,LoginPagetruetitle1,"fail to logout");
        
    }
    
  

}
