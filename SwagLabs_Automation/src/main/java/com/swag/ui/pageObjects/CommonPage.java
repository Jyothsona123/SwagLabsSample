package com.swag.ui.pageObjects;

import com.swag.ui.models.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CommonPage {

    Logger logger = Logger.getLogger(CommonPage.class);
    public CommonPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    @FindBy(className = "inventory_item_name")
    public WebElement product;


    @FindBy(className = "inventory_item_desc")
    public WebElement product_desc;

    @FindBy(className = "inventory_item_price")
    public WebElement price;

    public  String getProductName(){
        String productname =  product.getText();
        Reporter.log("Product Name :: "+productname,true);
        return productname;
    }

    public  String getProductDescription(){
        String productname =  product_desc.getText();
        Reporter.log("Product Description :: "+productname,true);
        return productname;
    }

    public  String getPrice(){
        String productPrice =  price.getText();
        Reporter.log("Product Price :: "+productPrice,true);
        return productPrice;
    }

    public void assertProductName(){
        Assert.assertEquals(Constants.PRODUCTNAME,getProductName());
    }

    public void assertProductDesc(){
        Assert.assertEquals(Constants.PRODUCT_DESC,getProductDescription());
    }

    public void assertPrice(){
        if(getPrice().contains(Constants.PRICE)){
            Assert.assertTrue(true,"Price is mathing");
            getPrice();
        }else{
            Assert.fail("Price is not matching");
        }
    }


    public void assertProductDetails(){
        assertProductName();
        assertProductDesc();
        assertPrice();
    }

}
