/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perficient.test.util;

import static com.perficient.test.US04.TC001_US04.lp;
import static com.perficient.test.US04.TC001_US04.sp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    public void setupFirefox(@Optional("true") String grid, @Optional("10.2.7.15") String hubHost, @Optional("4444") String hubPort) throws Exception {
          driver=new FirefoxDriver();
//        FirefoxProfile fxProfile = new FirefoxProfile();  
//        
//        fxProfile.setPreference("browser.download.folderList", 2);
//        fxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
//        fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream, application/vnd.ms-excel, application/x-msdownload");
//        fxProfile.setPreference("browser.download.panel.shown", false);  
//        if ("true".equals(grid)) {
//            DesiredCapabilities capability = DesiredCapabilities.firefox(); 
//           capability.setCapability(FirefoxDriver.PROFILE, fxProfile);
////            capability.setBrowserName("firefox");
//        //    capability.setPlatform(org.openqa.selenium.Platform.LINUX);
//            driver = new RemoteWebDriver(new URL("http://" + hubHost + ":" + hubPort + "/wd/hub"),capability);
//
//        } else {
//            driver = new EventFiringWebDriver(new FirefoxDriver(fxProfile)).register(new MyWebDriverListener());
//        }
//        String s_URL = "http://10.2.1.183:8080/TRS/page/score.jsp";
//       driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(WAIT_SECONDS, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, 15);
//        TestCaseBase.driver.navigate().to(s_URL);
//        /*driver*/
    }
     public static void login(String user, String password){
        lp.userElement.sendKeys(user);
        lp.passElement.sendKeys(password);
        lp.loginButton.click();        
    }
     public static void logout(){
         sp.logoutButton.click();
     }
     @AfterMethod
    public void closeFirefox() throws Exception {
        driver.quit();
      
    }
    
}
