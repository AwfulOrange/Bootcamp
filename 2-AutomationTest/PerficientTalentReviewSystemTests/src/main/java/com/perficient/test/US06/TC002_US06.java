/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US06;

import com.perficient.test.pages.LoginPage;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.testng.annotations.Test;

/**
 *
 * @author bootcamp19
 */
public class TC002_US06 extends TestCaseBase{
   // public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static ScorePage sp = new ScorePage();
    public static LoginPage lp = new LoginPage();
    @Test
    public static void filter() throws InterruptedException{
        TestCaseBase.driver.navigate().to(URL);
        PageFactory.initElements(TestCaseBase.driver,lp);
        login("testCM","testCM@gdc");
        PageFactory.initElements(TestCaseBase.driver, sp); 
        Thread.sleep(4000);
     //   ScorePage.filterbutton.click();
     //step 1 Input “Amo” in the filter below “Status”. 
        String name="an";
        ScorePage.filter0.sendKeys(name);
        Thread.sleep(1000);
        distinguish(name,0);
        Thread.sleep(1000);
        ScorePage.filter0.clear();
        Thread.sleep(1000);
  
    //step 2 Input “10” in the filter below “Performance”.    
        String score0="10";
        ScorePage.filter1.sendKeys(score0);
        Thread.sleep(1000);
        distinguish(score0,1);
        Thread.sleep(1000);
        ScorePage.filter1.clear();
        Thread.sleep(1000);
    //step 3 Input “10” in the filter below “Potential”.     
        String score1="10";    
        ScorePage.filter2.sendKeys(score1);
        Thread.sleep(1000);
        distinguish(score1,2);
        Thread.sleep(1000);
        ScorePage.filter2.clear();
        Thread.sleep(1000);
    //step 3 Input “10” in the filter below “Total”.   
        String score2="20";    
        ScorePage.filter3.sendKeys(score2);
        Thread.sleep(1000);
        distinguish(score2,3);
        Thread.sleep(1000);
        ScorePage.filter3.clear();
        Thread.sleep(1000);
     //step 4 Input "Ass" in the filter above Level
        String level="ass";
        ScorePage.filter4.sendKeys(level);
        Thread.sleep(1000);
        distinguish(level,4);
        Thread.sleep(1000);
        ScorePage.filter4.clear();
        Thread.sleep(1000);
     //Step 5 Input "Tes" in thefilter above Role
        String role="tes";
        ScorePage.filter5.sendKeys(role);
        Thread.sleep(1000);
        distinguish(role,5);
        Thread.sleep(1000);
        ScorePage.filter5.clear();
        Thread.sleep(1000);
        
        String status="sub";
        ScorePage.filter6.sendKeys(status);
        Thread.sleep(1000);
        distinguish(status,6);
        Thread.sleep(1000);
        ScorePage.filter6.clear();
        Thread.sleep(1000);
        
        logout();
    }
    public static void distinguish(String Keyword, int column){
        int j=column;
        int size = driver.findElements(By.xpath("/html/body/div/div/div")).size()-2;
       
        for(int i=0;i<size;i++)
        {
            
           String text =driver.findElement(By.id("p"+j+i)).getText();

          Assert.assertTrue(text.toLowerCase().contains(Keyword.toLowerCase()));
       //   System.out.println(i);
        }
    
    
 }
}
