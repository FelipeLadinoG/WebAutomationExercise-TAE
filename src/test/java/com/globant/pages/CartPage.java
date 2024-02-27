package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    WebDriver driver;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    public CartPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public void clickCheckout (){
        waitAllElements();
        this.checkoutButton.click();
    }
}
