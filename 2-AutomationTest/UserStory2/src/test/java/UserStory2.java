
import static junit.framework.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bootcamp19
 */
public class UserStory2 {
    public static WebDriver driver; 
    public static final String URL="  ";
    public static US2 cri=new US2();
    @BeforeMethod
    public static void setupFirefox() throws Exception{
        driver = new FirefoxDriver();
        PageFactory.initElements(driver, cri);
    
       
    }
    @Test
    public static void click(){
        cri.clickElement.click();
        String excepttitle="xxxxxxx";
        String truetitle=driver.getTitle();
        assertEquals(excepttitle,truetitle);
    }
    @AfterMethod
     public static void closeFirefox() throws Exception
    {
        driver.quit();
    }
}
