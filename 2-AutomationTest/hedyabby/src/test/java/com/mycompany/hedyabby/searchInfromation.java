/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hedyabby;
import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static org.openqa.grid.common.SeleniumProtocol.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author bootcamp19
 */
public class searchInfromation {
    public static WebDriver driver;
    public static final String URL = "http://www.baidu.com";
    public static searchpage sp = new searchpage();
    @BeforeMethod
    public static void setupFirefox() throws Exception{
        driver = new FirefoxDriver();
        PageFactory.initElements(driver, sp);
    
    }
    
    public static void search(String keyword){
        driver.navigate().to(URL);
        sp.searchElement.sendKeys(keyword);
        sp.submitElement.click();
    }
    @Test
    public void search() throws InterruptedException{
        search("perficient");
        Thread.sleep(6000);
        String excepttitle="perficient_百度搜索";
        String truetitle=driver.getTitle();
        
        assertEquals(excepttitle,truetitle);
    }
    @AfterMethod
    public static void closeFirefox() throws Exception
    {
        driver.quit();
    }
}