/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.US02;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ScorePage;

/**
 *
 * @author bootcamp19
 */
public class US01_TC001 {
     public static WebDriver driver;

    public static final String s_URL="http://localhost:8080/TRS/page/score.jsp";

    public static ScorePage page1 = new ScorePage();
   

    @BeforeMethod
    public static void setupFirefox() throws Exception {

        driver = new FirefoxDriver();

        PageFactory.initElements(driver, page1);
        /*driver*/
    }

    public static void login() throws Exception {
        driver.navigate().to(s_URL);

        List<String> list = new ArrayList<String>();
        list.add("/html/body/div/div/form/div[1]/table/tbody/tr[2]/td[1]");
        list.add("/html/body/div/div/form/div[1]/div/h[1]");
        list.add("/html/body/div/div/form/div[1]/div/h[2]");
        list.add("/html/body/div/div/form/div[1]/div/table[3]/tbody/tr[1]/th/select");
        list.add("/html/body/div/div/form/div[1]/div/table[3]/tbody/tr[2]/th/select");
        list.add("/html/body/div/div/form/div[1]/div/table[3]/tbody/tr[4]/th/select");
        list.add("/html/body/div/div/form/div[1]/div/table[3]/tbody/tr[5]/th/select");
        for(int i=0;i<list.size();i++){
            Thread.sleep(2000);
            driver.findElement(By.xpath(list.get(i))).click();    
        }

    }

    @Test
    public void ClickProject() throws Exception {

        login();
       // assertEquals("Project - Perficient China TPT",driver.getTitle());

        Thread.sleep(6000);

    }

    @AfterMethod
    public static void closeFirefox() throws Exception {
        driver.quit();
    }

    
}
