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
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author bootcamp19
 */
public class TC001_US06 extends TestCaseBase{
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static ScorePage sp = new ScorePage();
    public static LoginPage lp = new LoginPage();
    
    @Test
    public static void click() throws InterruptedException{
        PageFactory.initElements(TestCaseBase.driver, sp); 
        PageFactory.initElements(TestCaseBase.driver, lp);
        
        TestCaseBase.driver.navigate().to(URL);
        login("testCM","testCM@gdc");
        Thread.sleep(2000);
        

        sp.sort0.click();
        Assert.assertTrue(verifySort(0,1),"Fail to sort");
        sp.sort0.click();
        Assert.assertTrue(verifySort(0,2),"Fail to sort");
               
        sp.sort1.click();
        Assert.assertTrue(verifySort(1,1),"Fail to sort");
        sp.sort1.click();
        Assert.assertTrue(verifySort(1,2),"Fail to sort");
        
        sp.sort2.click();
        Assert.assertTrue(verifySort(2,1),"Fail to sort");
        sp.sort2.click();
        Assert.assertTrue(verifySort(2,2),"Fail to sort");
        
        sp.sort3.click();
        Assert.assertTrue(verifySort(3,1),"Fail to sort");
        sp.sort3.click();
        Assert.assertTrue(verifySort(3,2),"Fail to sort");
        
        sp.sort4.click();
        Assert.assertTrue(verifySort(4,1),"Fail to sort");
        sp.sort4.click();
        Assert.assertTrue(verifySort(4,2),"Fail to sort");
        
        
        
        
    }
    
        public static boolean verifySort(int column,int time){
            List<String> element=new ArrayList();
            int size = driver.findElements(By.xpath("/html/body/header/div/form/div")).size();
            for(int i=0;i<size;i++){
                element.add(driver.findElement(By.id("p"+column+i)).getText());               
            }
            
            if (time == 1){
                
                for(int i=0;i<size;i++){
                    for(int j=i+1;i<size;j++){
                        if (element.get(j).compareToIgnoreCase((element.get(i)))<0 )
                        return false;                                                             
                    }
                 return true;
                }
            }
           if (time == 2){
                
                for(int i=0;i<size;i++){
                    for(int j=i+1;i<size;j++){
                        if (element.get(j).compareToIgnoreCase((element.get(i)))>0 )
                        return false;                                                             
                    }
                 return true;         
                }
            }
           return false;


        }
  
}
