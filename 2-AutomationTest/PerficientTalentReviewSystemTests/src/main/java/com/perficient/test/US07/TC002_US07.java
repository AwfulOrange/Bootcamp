/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US07;



import com.perficient.test.pages.LoginPage;
import com.perficient.test.pages.PMOleadPage;
import com.perficient.test.pages.ScorePage;
import com.perficient.test.util.TestCaseBase;
import static com.perficient.test.util.TestCaseBase.driver;
import static com.perficient.test.util.TestCaseBase.login;
import static com.perficient.test.util.TestCaseBase.logout;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author bootcamp19
 */
public class TC002_US07 extends TestCaseBase{
    public static final String URL="http://10.2.1.183:8080/TRS/page/score.jsp";
    public static ScorePage sp = new ScorePage();
    public static LoginPage lp = new LoginPage();
    public static PMOleadPage pp = new PMOleadPage();
    
    @Test
    public static void sort() throws InterruptedException{
        TestCaseBase.driver.navigate().to(URL);
        PageFactory.initElements(TestCaseBase.driver,lp);
        login("testEM","testEM@gdc");
        PageFactory.initElements(TestCaseBase.driver, sp); 
        Thread.sleep(4000);
        
        //click PMO-leader Tab
        TestCaseBase.driver.findElement(By.xpath("/html/body/header/div/table/tbody/tr/td[2]/a/b")).click();
        PageFactory.initElements(TestCaseBase.driver, pp);
        Thread.sleep(2000);
        
        pp.sort0.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(0,2),"Fail to sort");
        pp.sort0.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(0,1),"Fail to sort");
        
        pp.sort1.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(1,2),"Fail to sort");
        pp.sort1.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(1,1),"Fail to sort");
               
        pp.sort2.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(2,2),"Fail to sort");
        pp.sort2.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(2,1),"Fail to sort");
        
        pp.sort3.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(3,2),"Fail to sort");
        pp.sort3.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(3,1),"Fail to sort");
        
        pp.sort4.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(4,2),"Fail to sort");
        pp.sort4.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifyNum(4,1),"Fail to sort");
        
        pp.sort5.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(5,2),"Fail to sort");
        pp.sort5.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(5,1),"Fail to sort");
        
        pp.sort6.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(6,2),"Fail to sort");
        pp.sort6.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(6,1),"Fail to sort");
        
        pp.sort7.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(7,2),"Fail to sort");
        pp.sort7.click();
        Thread.sleep(2000);
        Assert.assertTrue(verifySort(7,1),"Fail to sort");
        
        logout();
        
        
        
    }
    
        public static boolean verifySort(int column,int time){
            List<String> element=new ArrayList();
            int size = driver.findElements(By.xpath("/html/body/div/div/div")).size()-2;
            //System.out.println("++++++++++++++"+size);
            for(int i=0;i<size;i++){
                element.add(driver.findElement(By.id("p"+column+i)).getText().trim());               
            }
            
            if (time == 1){
                
                for(int i=0;i<size;i++){
                    //System.out.println(element.get(i));
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
            
                    
            int size = driver.findElements(By.xpath("/html/body/div/div/div")).size()-2;
            //System.out.println("------------****----"+size);
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
