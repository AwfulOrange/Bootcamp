/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.util;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 *
 * @author bootcamp19
 */
public class TestCaseBase {
    public static WebDriver driver;
    public static int WAIT_SECONDS = 15;
    public static String url;
    public static WebDriverWait wait;
    @Parameters({"grid", "hubHost", "hubPort"})
    @BeforeMethod
    public void setupFirefox(@Optional("true") String grid, @Optional("10.2.128.93") String hubHost, @Optional("4444") String hubPort) throws Exception {
          if ("true".equals(grid)) {
            DesiredCapabilities capability = DesiredCapabilities.firefox();        
            driver = new EventFiringWebDriver(new RemoteWebDriver(new URL("http://" + hubHost + ":" + hubPort + "/wd/hub"), capability)).register(new MyWebDriverListener());

        } else {
            driver = new EventFiringWebDriver(new FirefoxDriver()).register(new MyWebDriverListener());
        }
        String s_URL = "http://localhost:8080/TRS/page/score.jsp";
       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_SECONDS, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
        TestCaseBase.driver.navigate().to(s_URL);
        /*driver*/
    }
     @AfterMethod
    public void closeFirefox() throws Exception {
        driver.quit();
      
    }
    
}
