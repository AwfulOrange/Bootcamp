/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US06;


import com.perficient.test.pages.LoginPage;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.driver;
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
        login("testEM","testEM@gdc");
        Thread.sleep(2000);
        

        sp.sort0.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(0,1),"Fail to sort");
        sp.sort0.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(0,2),"Fail to sort");
               
        sp.sort1.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(2,1),"Fail to sort");
        sp.sort1.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(2,2),"Fail to sort");
        
        ScorePage.sort2.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(3,1),"Fail to sort");
        ScorePage.sort2.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(3,2),"Fail to sort");
        
        ScorePage.sort3.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(4,1),"Fail to sort");
        ScorePage.sort3.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(4,2),"Fail to sort");
        
        ScorePage.sort4.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(5,1),"Fail to sort");
        ScorePage.sort4.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(5,2),"Fail to sort");
        
        ScorePage.sort5.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(6,1),"Fail to sort");
        ScorePage.sort5.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(6,2),"Fail to sort");
        
        ScorePage.sort6.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(7,1),"Fail to sort");
        ScorePage.sort6.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(7,2),"Fail to sort");
        logout();
        
        
        
    }
    
        public static boolean verifySort(int column,int time){
            List<String> element=new ArrayList();
            int size = driver.findElements(By.xpath("/html/body/header/div/form/div")).size();
            for(int i=0;i<size;i++){
                element.add(driver.findElement(By.id("p"+column+i)).getText().trim());               
            }
            
            if (time == 1){
                
                for(int i=0;i<size;i++){
                    System.out.println(element.get(i));
                    for(int j=i+1;j<size;j++){
                        if (element.get(j).compareToIgnoreCase((element.get(i)))<0 )
                        return false;                                                             
                    }
                 
                }
             return true;
            }
           if (time == 2){
                
                for(int i=0;i<size;i++){
                    for(int j=i+1;j<size;j++){
                        if (element.get(j).compareToIgnoreCase((element.get(i)))>0 )
                        return false;                                                             
                    }
                       
                }
                return true;   
            }
           return false;


        }
        
        public static boolean verifyNum(int column,int time){
            List<String> element=new ArrayList();
            int size = driver.findElements(By.xpath("/html/body/header/div/form/div")).size();
            for(int i=0;i<size;i++){
                element.add(driver.findElement(By.id("p"+column+i)).getText().trim());               
            }
            
            if (time == 1){
                
                for(int i=0;i<size;i++){
                    //System.out.println(element.get(i));
                    for(int j=i+1;j<size;j++){
                        Integer a=Integer.parseInt(element.get(j));
                        Integer b=Integer.parseInt((element.get(i)));
                        
                        if (a.compareTo(b)<0 )
                        return false;                                                             
                    }
                 
                }
             return true;
            }
           if (time == 2){
                
                for(int i=0;i<size;i++){
                    for(int j=i+1;j<size;j++){
                        Integer a=Integer.parseInt(element.get(j));
                        Integer b=Integer.parseInt((element.get(i)));
                        
                        if (a.compareTo(b)>0 )
                        return false;                                                               
                    }
                       
                }
                return true;   
            }
           return false;


        }
  
}
