package com.swag.ui.driverManger;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPage extends WebdriverManager {

	WebDriver driver;
	public WebPage(WebDriver driver) {
		super(driver);
		driver= this.driver;
	}
	
	
	public void waitElementClickable(WebElement submit) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(submit));
	}
	

}
