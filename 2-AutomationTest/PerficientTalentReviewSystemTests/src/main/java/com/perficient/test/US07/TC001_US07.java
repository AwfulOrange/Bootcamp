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
    public static final String URL="http://localhost:8080/TRS/page/score.jsp";
    //public static final String URL="http://localhost:8080/TRS/page/score.jsp";
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
        
        String reviewer="tes";
        PMOleadPage.filter0.sendKeys(reviewer);
        Thread.sleep(1000);
        distinguish(reviewer,0);
        Thread.sleep(1000);
        PMOleadPage.filter0.clear();
        Thread.sleep(1000);
        
        String name="amo";
        PMOleadPage.filter1.sendKeys(name);
        Thread.sleep(1000);
        distinguish(name,1);
        Thread.sleep(1000);
        PMOleadPage.filter1.clear();
        Thread.sleep(1000);
  
    //step 2 Input “2” in the filter below “Achieving Results”.    
        String score01="5";
        PMOleadPage.filter8.sendKeys(score01);
        Thread.sleep(1000);
        distinguish(score01,2);
        Thread.sleep(1000);
        PMOleadPage.filter8.clear();
        Thread.sleep(3000);
        
    //step 3 Input “2” in the filter below “Organization Impact”.    
        String score02="5";
        PMOleadPage.filter9.sendKeys(score02);
        Thread.sleep(1000);
        distinguish(score02,2);
        Thread.sleep(1000);
        PMOleadPage.filter9.clear();
        Thread.sleep(3000);
        
    //step 4 Input “5” in the filter below “Learning Agility”.    
        String score11="5";    
        PMOleadPage.filter10.sendKeys(score11);
        Thread.sleep(1000);
        distinguish(score11,3);
        Thread.sleep(1000);
        PMOleadPage.filter10.clear();
        Thread.sleep(1000);
        
    //step 5 Input “5” in the filter below “ Versatility”.     
        String score12="5";    
        PMOleadPage.filter11.sendKeys(score12);
        Thread.sleep(1000);
        distinguish(score12,3);
        Thread.sleep(1000);
        PMOleadPage.filter11.clear();
        Thread.sleep(1000);
        
    //step 6 Input “10” in the filter below “Performance”.     
        String score0="10";    
        PMOleadPage.filter2.sendKeys(score0);
        Thread.sleep(1000);
        distinguish(score0,3);
        Thread.sleep(1000);
        PMOleadPage.filter2.clear();
        Thread.sleep(1000);
        
    //step 7 Input “10” in the filter below “Potential”.     
        String score1="10";    
        PMOleadPage.filter3.sendKeys(score1);
        Thread.sleep(1000);
        distinguish(score1,3);
        Thread.sleep(1000);
        PMOleadPage.filter3.clear();
        Thread.sleep(1000);
        
    //step 8 Input “20” in the filter below “Total”.   
        String score2="20";    
        PMOleadPage.filter4.sendKeys(score2);
        Thread.sleep(1000);
        distinguish(score2,4);
        Thread.sleep(1000);
        PMOleadPage.filter4.clear();
        Thread.sleep(1000);
  
     
    //step 9 Input “20” in the filter below “satus”.     
        String status="up";
        PMOleadPage.filter7.sendKeys(status);
        Thread.sleep(1000);
        distinguish(status,7);
        Thread.sleep(1000);
        PMOleadPage.filter7.clear();
        Thread.sleep(1000);
        logout();
    }
}
