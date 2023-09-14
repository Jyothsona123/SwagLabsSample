package com.swag.ui.functionalTests;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.swag.ui.driverManger.WebdriverManager;
import com.swag.ui.models.Browser;
import com.swag.ui.pageObjects.CartPage;
import com.swag.ui.pageObjects.CommonPage;
import com.swag.ui.pageObjects.LoginPage;
import com.swag.ui.pageObjects.ProductPage;

public class Swag_NegativeTests {
	
	
	WebDriver driver;
	@Test
	public void validateLockedUser() {
		driver = WebdriverManager.launchBrowser(Browser.Chrome);
		LoginPage login = new LoginPage(driver);
		login.lockUserLogin().validateLockUser();
		Reporter.log("Verified Locked user login",true);
	
	}
	
	@Test
    public void validateRemoveCart(){
         driver = WebdriverManager.launchBrowser(Browser.Chrome);
        LoginPage login = new LoginPage(driver);
        login.loginSwag();

        CommonPage commonPage = new CommonPage(driver);
        commonPage.assertProductDetails();
        ProductPage productPage = new ProductPage(driver);
        productPage.addtocart().verifyRemoveCart_Displayed();
        productPage.removeCart().verifyAddoCart_Displayed();
        Reporter.log("Successfully verified add to cart and remove cart ",true);
    }
	
    @Test
    public void validateRemoveCart_InvalidUser(){
         driver = WebdriverManager.launchBrowser(Browser.Chrome);
        LoginPage login = new LoginPage(driver);
        login.problemUserLogin();

        CommonPage commonPage = new CommonPage(driver);
        commonPage.assertProductDetails();
        ProductPage productPage = new ProductPage(driver);
        productPage.addtocart().verifyRemoveCart_Displayed();
        productPage.removeCart().verifyRemoveCart_Displayed();
        Reporter.log("Unable to Remove Product from Cart",true);
        
        
    }
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		Reporter.log("**** SuccessFully Browser closed****",true);
	}


}
