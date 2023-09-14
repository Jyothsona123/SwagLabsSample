package com.swag.ui.functionalTests;

import com.swag.ui.driverManger.WebdriverManager;
import com.swag.ui.models.Browser;
import com.swag.ui.models.Constants;
import com.swag.ui.pageObjects.CartPage;
import com.swag.ui.pageObjects.CommonPage;
import com.swag.ui.pageObjects.LoginPage;
import com.swag.ui.pageObjects.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.TextReporter;

public class Swag_PositiveTests {

	WebDriver driver;
	
	
	@Test
	public void validateSuccessLogin() {
		driver = WebdriverManager.launchBrowser(Browser.Chrome);
        LoginPage login = new LoginPage(driver);
        login.loginSwag();
        Reporter.log("**** SuccessFully Logged in ****",true);
        //Verifying Product details post login
        CommonPage commonPage = new CommonPage(driver);
        commonPage.assertProductDetails();
        Reporter.log("Verified Product details are visible",true);
	}
	
	@Test
    public void validateInventoryPage() {
    	driver = WebdriverManager.launchBrowser(Browser.Chrome);
        LoginPage login = new LoginPage(driver);
        login.loginSwag();
        String url = WebdriverManager.getUrl();
        Assert.assertEquals(url, Constants.INVENTORY_URL,"INVENTORY URL is not matching");
        Reporter.log("actual :: "+url+" Expected :: "+Constants.INVENTORY_URL,true);
    	
    }
	
 
	 @Test
	    public void placeSwag_Order_e2e(){
	         driver = WebdriverManager.launchBrowser(Browser.Chrome);
	        LoginPage login = new LoginPage(driver);
	        login.loginSwag();

	        CommonPage commonPage = new CommonPage(driver);
	        commonPage.assertProductDetails();
	        ProductPage productPage = new ProductPage(driver);
	        productPage.addtocart().verifyRemoveCart_Displayed().clickonCart();

	        commonPage.assertProductDetails();
	        CartPage cartPage = new CartPage(driver);
	        cartPage.clickOnCheckout().fillUserDetails().verifyOrderSummary();
	        commonPage.assertProductDetails();
	        cartPage.clickonFinish().completeOrder();
	    }
    
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    	Reporter.log("**** SuccessFully Browser closed****",true);
    }
}
