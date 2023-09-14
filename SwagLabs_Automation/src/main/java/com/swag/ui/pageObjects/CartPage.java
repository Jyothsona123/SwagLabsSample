package com.swag.ui.pageObjects;

import com.swag.ui.models.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CartPage {
    Logger logger = Logger.getLogger(CartPage.class);
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "checkout")
    public WebElement checkout;




    @FindBy(id = "first-name")
    public WebElement firstName;


    @FindBy(id = "last-name")
    public WebElement lastName;


    @FindBy(id = "postal-code")
    public WebElement postalcode;


    @FindBy(id = "continue")
    public WebElement continueBt;







    @FindBy(id = "finish")
    public WebElement finish;




    @FindBy(className = "summary_value_label")
    public WebElement successcard;


    @FindBy(className = "complete-header")
    public WebElement complete;

    public void completeOrder(){
        String success = complete.getText();
        Assert.assertEquals(success, Constants.ORDERSUMMARY);
        Reporter.log("Actual :: "+success+" -- Expected :: "+Constants.ORDERSUMMARY,true);
    }


    public CartPage clickOnCheckout(){
        checkout.click();
        Reporter.log("Clicking on checkout",true);
        return this;
    }


    public CartPage fillUserDetails(){
        firstName.sendKeys("Tester first name");
        lastName.sendKeys("Tester Last name");
        postalcode.sendKeys("12345");
        continueBt.click();
        Reporter.log("Filling User details",true);
        return this;
    }


    public CartPage clickonFinish(){
        finish.click();
        Reporter.log("Clciking on Finish Button",true);
        return this;
    }

    public String  verifyOrderSummary(){
        String order =  successcard.getText();
        Reporter.log("Order number is created :: "+order,true);
        return order;
    }

}
