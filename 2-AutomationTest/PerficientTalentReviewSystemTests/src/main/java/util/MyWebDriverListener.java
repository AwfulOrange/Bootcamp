/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 *
 * @author perficient
 */
public class MyWebDriverListener implements WebDriverEventListener {

    private final Log log = LogFactory.getLog(this.getClass());

    @Override
    public void beforeNavigateTo(String arg0, WebDriver wd) {
        log.info("Just before beforeNavigateTo " + arg0);
    }

    @Override
    public void afterNavigateTo(String arg0, WebDriver wd) {
        log.info("Inside the afterNavigateTo to " + arg0);
    }

    @Override
    public void beforeNavigateBack(WebDriver arg0) {
     //   log.info("Just before beforeNavigateBack " + arg0.getCurrentUrl());
    }

    @Override
    public void afterNavigateBack(WebDriver arg0) {
     //   log.info("Inside the after navigateback to " + arg0.getCurrentUrl());
    }

    @Override
    public void beforeNavigateForward(WebDriver arg0) {
      //  log.info("Just before beforeNavigateForward " + arg0.getCurrentUrl());
    }

    @Override
    public void afterNavigateForward(WebDriver arg0) {

     //   log.info("Inside the afterNavigateForward to " + arg0.getCurrentUrl());
    }

    @Override
    public void beforeFindBy(By by, WebElement arg1, WebDriver wd) {
     //   log.info("Find happened on " );

    }
    @Override
    public void afterFindBy(By arg0, WebElement arg1, WebDriver wd) {

        log.info("Find happened on " +arg0.toString());
    }

    @Override
    public void beforeClickOn(WebElement arg0, WebDriver wd) {
     //   log.info("About to click on the " );
    }

    @Override
    public void afterClickOn(WebElement arg0, WebDriver wd) {

        log.info("inside method afterClickOn on " );
    }

    @Override
    public void beforeChangeValueOf(WebElement we, WebDriver wd) {
    //    log.info("Inside the beforeChangeValueOf method");
    }

    @Override
    public void afterChangeValueOf(WebElement arg0, WebDriver wd) {

        log.info("inside method afterChangeValueOf on "+arg0.getText() );
    }

    @Override
    public void beforeScript(String arg0, WebDriver wd) {
        log.info("Just before beforeScript " + arg0);
    }

    @Override
    public void afterScript(String arg0, WebDriver wd) {

        log.info("Inside the afterScript to, Script is " + arg0);
    }

    @Override
    public void onException(Throwable arg0, WebDriver wd) {
        log.info("Exception occured at " + arg0.getMessage());
    }

  
}
