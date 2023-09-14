package com.swag.ui.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class ProductPage {
    Logger logger = Logger.getLogger(ProductPage.class);
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    @FindBy(className = "inventory_item_name")
    public WebElement product;


    @FindBy(className = "inventory_item_desc")
    public WebElement product_desc;

    @FindBy(className = "inventory_item_price")
    public WebElement price;


    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addtoCart;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeCart;


    @FindBy(className = "shopping_cart_link")
    public WebElement cart;



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


    public  ProductPage addtocart(){
        getProductName();
        getProductDescription();
        getPrice();
        addtoCart.click();
        Reporter.log("Adding product to Cart",true);
        return this;
    }

    public ProductPage removeCart(){
        removeCart.click();
        Reporter.log("Removing product from cart",true);
        return this;
    }


    public void clickonCart(){
        cart.click();
        Reporter.log("clicking on cart",true);
    }

    public ProductPage verifyAddoCart_Displayed(){
        boolean flag = addtoCart.isDisplayed();
        if (flag){
            Reporter.log("Add to cart is displayed",true);
        }else {
            Assert.fail("Add to cart button not displayed");
        }
        return this;
    }


    public ProductPage verifyRemoveCart_Displayed(){
        boolean flag = removeCart.isDisplayed();
        if (flag){
            Reporter.log("removeCart is displayed",true);
        }else {
            Assert.fail("removeCart button not displayed");
        }
        return this;
    }







}
