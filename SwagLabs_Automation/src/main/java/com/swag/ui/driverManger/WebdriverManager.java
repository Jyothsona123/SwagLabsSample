package com.swag.ui.driverManger;

import com.swag.ui.models.Browser;
import com.swag.ui.models.Constants;
import com.swag.ui.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class WebdriverManager {
    static WebDriver driver=null;
    public WebdriverManager(WebDriver driver){
        this.driver=driver;
    }
    public static WebDriver launchBrowser(Browser browser){
            switch (browser) {
                case Chrome:
                    driver = new ChromeDriver();
                    System.out.println("Launching Chrome Browser");
                    break;
                case Firefox:
                    driver = new FirefoxDriver();
                    System.out.println("Launching Firefox Browser");
                    break;
                case Safari:
                    driver = new SafariDriver();
                    System.out.println("Launching Safari Browser");
                    break;
            }
            driver.get(PropertyReader.geValue(Constants.URL));
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        return driver;
    }


    public static  void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String getUrl() {
    	String url = driver.getCurrentUrl();
    	Reporter.log("Getting current Url :: "+url,true);
    	return url;
    }
    
    
    






}
