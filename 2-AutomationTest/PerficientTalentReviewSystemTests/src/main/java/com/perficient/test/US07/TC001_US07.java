/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US07;

import static com.perficient.test.US05.TC001_US05.pp;
import static com.perficient.test.US06.TC002_US06.distinguish;
import com.perficient.test.pages.LoginPage;
import com.perficient.test.pages.PMOleadPage;
import static com.perficient.test.pages.PMOleadPage.filter0;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 *
 * @author bootcamp19
 */
public class TC001_US07 extends TestCaseBase{
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static ScorePage sp = new ScorePage();
    public static LoginPage lp = new LoginPage();
    @Test
    public static void filter() throws InterruptedException{
        TestCaseBase.driver.navigate().to(URL);
        PageFactory.initElements(TestCaseBase.driver,lp);
        login("testEM","testEM@gdc");
        PageFactory.initElements(TestCaseBase.driver, sp); 
        Thread.sleep(4000);
        
        //click PMO-leader Tab
        TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/table/tbody/tr/td[2]/a/b")).click();
        PageFactory.initElements(TestCaseBase.driver, pp);
        Thread.sleep(2000);
        
        String reviewer="xxxxxxx";
        PMOleadPage.filter1.sendKeys(reviewer);
        Thread.sleep(2000);
        distinguish(reviewer,0);
        Thread.sleep(2000);
        PMOleadPage.filter1.clear();
        Thread.sleep(2000);
        
        String name="amo";
        PMOleadPage.filter1.sendKeys(name);
        Thread.sleep(2000);
        distinguish(name,2);
        Thread.sleep(2000);
        PMOleadPage.filter1.clear();
        Thread.sleep(2000);
  
    //step 2 Input “2” in the filter below “Performance”.    
        String score0="2";
        PMOleadPage.filter2.sendKeys(score0);
        Thread.sleep(3000);
        distinguish(score0,3);
        Thread.sleep(3000);
        PMOleadPage.filter2.clear();
        Thread.sleep(3000);
    //step 3 Input “5” in the filter below “Potential”.     
        String score1="5";    
        PMOleadPage.filter3.sendKeys(score1);
        Thread.sleep(2000);
        distinguish(score1,4);
        Thread.sleep(2000);
        PMOleadPage.filter3.clear();
        Thread.sleep(2000);
    //step 3 Input “7” in the filter below “Total”.   
        String score2="7";    
        PMOleadPage.filter4.sendKeys(score2);
        Thread.sleep(2000);
        distinguish(score2,5);
        Thread.sleep(2000);
        PMOleadPage.filter4.clear();
        Thread.sleep(2000);
     //step 4 Input "Ass" in the filter above Level
        String level="ass";
        PMOleadPage.filter5.sendKeys(level);
        Thread.sleep(2000);
        distinguish(level,6);
        Thread.sleep(2000);
        PMOleadPage.filter5.clear();
        Thread.sleep(2000);
     //Step 5 Input "Tes" in thefilter above Role
        String role="tes";
        PMOleadPage.filter6.sendKeys(role);
        Thread.sleep(2000);
        distinguish(role,7);
        Thread.sleep(2000);
        PMOleadPage.filter6.clear();
        Thread.sleep(2000);
        
        //Step 6 Input "sub" in thefilter above Status
        String status="sub";
        PMOleadPage.filter7.sendKeys(status);
        Thread.sleep(2000);
        distinguish(status,8);
        Thread.sleep(2000);
        PMOleadPage.filter7.clear();
        Thread.sleep(2000);
        
        
        logout();
    }
}
