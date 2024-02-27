package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    WebDriver driver;

    @FindBy (css = "input#user-name")
    private WebElement userNameField;
    @FindBy (css = "#password")
    private WebElement password;
    @FindBy (css = "#login-button")
    private WebElement loginButton;

    public HomePage (WebDriver driver, String url){
        super(driver);
        driver.get(url);
    }


    public void setCredentials(String username, String password){
        this.userNameField.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

}
