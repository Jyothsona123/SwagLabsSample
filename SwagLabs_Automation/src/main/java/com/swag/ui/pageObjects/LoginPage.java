package com.swag.ui.pageObjects;

import com.swag.ui.driverManger.WebPage;
import com.swag.ui.driverManger.WebdriverManager;
import com.swag.ui.models.Constants;
import com.swag.ui.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage extends WebPage{
    public LoginPage(WebDriver driver) {
    	super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "user-name")
    public WebElement userName;


    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement submit;
    
    @FindBy(xpath = "//h3")
    public WebElement lockedError;
    
    



    public void loginSwag(){
        userName.sendKeys(PropertyReader.geValue(Constants.USERNAME));
        password.sendKeys(PropertyReader.geValue(Constants.PASSWORD));
        submit.click();
        Reporter.log("Successfully logged in With Valid User",true);
    }
    
    public LoginPage lockUserLogin() {
    	userName.sendKeys(PropertyReader.geValue(Constants.LOCKUSER));
        password.sendKeys(PropertyReader.geValue(Constants.PASSWORD));
        submit.click();
        Reporter.log("Tried to loggin with Locked User",true);
        return this;
    }
    
    public LoginPage problemUserLogin() {
    	userName.sendKeys(PropertyReader.geValue(Constants.PROBLEM_USER));
        password.sendKeys(PropertyReader.geValue(Constants.PASSWORD));
        Reporter.log("Successfully logged in With Problem User",true);
        submit.click();
        return this;
    }
    
    public void validateLockUser() {
    	String error = lockedError.getText();
    	Assert.assertEquals(error, Constants.LOCKEDERROR);
    	Reporter.log("actual  :: "+error+"  expected :: "+Constants.LOCKEDERROR,true);
    }

}
