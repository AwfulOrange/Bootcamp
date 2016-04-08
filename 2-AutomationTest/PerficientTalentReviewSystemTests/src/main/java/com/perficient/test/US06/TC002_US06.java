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
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static ScorePage sp = new ScorePage();
    public static LoginPage lp = new LoginPage();
    @Test
    public static void filter() throws InterruptedException{
        TestCaseBase.driver.navigate().to(URL);
        PageFactory.initElements(TestCaseBase.driver,lp);
        login("testEM","testEM@gdc");
        PageFactory.initElements(TestCaseBase.driver, sp); 
        Thread.sleep(6000);
     //   ScorePage.filterbutton.click();
     //step 1 Input “Amo” in the filter below “Status”. 
        String name="amo";
        ScorePage.filter0.sendKeys(name);
        Thread.sleep(2000);
        distinguish(name,0);
        Thread.sleep(2000);
        ScorePage.filter0.clear();
        Thread.sleep(2000);
  
    //step 2 Input “10” in the filter below “Performance”.    
        String score0="5";
        ScorePage.filter1.sendKeys(score0);
        Thread.sleep(3000);
        distinguish(score0,2);
        Thread.sleep(3000);
        ScorePage.filter1.clear();
        Thread.sleep(3000);
    //step 3 Input “10” in the filter below “Potential”.     
        String score1="2";    
        ScorePage.filter2.sendKeys(score1);
        Thread.sleep(2000);
        distinguish(score1,3);
        Thread.sleep(2000);
        ScorePage.filter2.clear();
        Thread.sleep(2000);
    //step 3 Input “10” in the filter below “Total”.   
        String score2="7";    
        ScorePage.filter3.sendKeys(score2);
        Thread.sleep(2000);
        distinguish(score2,4);
        Thread.sleep(2000);
        ScorePage.filter3.clear();
        Thread.sleep(2000);
     //step 4 Input "Ass" in the filter above Level
        String level="ass";
        ScorePage.filter4.sendKeys(level);
        Thread.sleep(2000);
        distinguish(level,5);
        Thread.sleep(2000);
        ScorePage.filter4.clear();
        Thread.sleep(2000);
     //Step 5 Input "Tes" in thefilter above Role
        String role="tes";
        ScorePage.filter5.sendKeys(role);
        Thread.sleep(2000);
        distinguish(role,6);
        Thread.sleep(2000);
        ScorePage.filter5.clear();
        Thread.sleep(2000);
        //Step 5 Input "Tes" in thefilter above Role
        String status="sub";
        ScorePage.filter6.sendKeys(status);
        Thread.sleep(2000);
        distinguish(status,7);
        Thread.sleep(2000);
        ScorePage.filter6.clear();
        Thread.sleep(2000);
        
        logout();
    }
    public static void distinguish(String Keyword, int column){
        int j=column;
        int size = driver.findElements(By.xpath("/html/body/header/div/form/div")).size();
       
        for(int i=0;i<size;i++)
        {
            
           String text =driver.findElement(By.id("p"+j+i)).getText();

          Assert.assertTrue(text.toLowerCase().contains(Keyword.toLowerCase()));
       //   System.out.println(i);
        }
    
    
 }
}
