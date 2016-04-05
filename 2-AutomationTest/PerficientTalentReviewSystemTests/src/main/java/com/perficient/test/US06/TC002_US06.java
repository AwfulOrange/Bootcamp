/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US06;

import com.perficient.test.pages.LoginPage;
import com.perficient.test.pages.ScorePage;
import static com.perficient.test.pages.ScorePage.performancescore;
import static com.perficient.test.pages.ScorePage.potentialscore;
import static com.perficient.test.pages.ScorePage.totalscore;
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
        login("testCM","testCM@gdc");
        PageFactory.initElements(TestCaseBase.driver, sp); 
        Thread.sleep(6000);
     //step 1 Input “1” in the filter below “Reviewee ID”.   
        String ID="1";
        ScorePage.filter0.sendKeys(ID);
        Thread.sleep(3000);
        distinguish(ID,0);
        Thread.sleep(3000);
        ScorePage.filter0.clear();
        Thread.sleep(3000);
     //step 2 Input “amo” in the filter below “Status”. 
        String name="amo";
        ScorePage.filter1.sendKeys(name);
        Thread.sleep(3000);
        distinguish(name,1);
        Thread.sleep(3000);
        ScorePage.filter1.clear();
        Thread.sleep(3000);
     //step 3Input “C” in the filter below “Status”. 
        String status="c";
        ScorePage.filter2.sendKeys(status);
        Thread.sleep(3000);
        distinguish(status,2);
        Thread.sleep(3000);
        ScorePage.filter2.clear();
        Thread.sleep(3000);
    //step 4 Input “10” in the filter below “Performance”.    
        String score="10";
        ScorePage.filter3.sendKeys(score);
        Thread.sleep(3000);
        distinguish(score,3);
        Thread.sleep(3000);
        ScorePage.filter3.clear();
        Thread.sleep(3000);
    //step 5 Input “10” in the filter below “Potential”.         
        ScorePage.filter4.sendKeys(score);
        Thread.sleep(3000);
        distinguish(score,4);
        Thread.sleep(3000);
        ScorePage.filter4.clear();
        Thread.sleep(3000);
    //step 5 Input “10” in the filter below “Total”.       
        ScorePage.filter5.sendKeys(score);
        Thread.sleep(3000);
        distinguish(score,5);
        Thread.sleep(3000);
        ScorePage.filter5.clear();
        Thread.sleep(3000);
        
        logout();
    }
    public static void distinguish(String Keyword, int column){
        int j=column;
        int size = driver.findElements(By.xpath("/html/body/header/div/form/div")).size();
        for(int i=0;i<size;i++)
        {
            
            String text =driver.findElement(By.id("p"+j+i)).getText();
            boolean flag = text.contains(Keyword);
            Assert.assertTrue(flag);
        }
    
    
 }
}
