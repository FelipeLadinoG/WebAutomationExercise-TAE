package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInfoPage extends BasePage {

    WebDriver driver;
    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;


    public PersonalInfoPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public void setPersonalInfo(String fistName, String lastName, String postalCode){
        waitAllElements();
        this.firstNameField.sendKeys(fistName);
        this.lastNameField.sendKeys(lastName);
        this.postalCodeField.sendKeys(postalCode);
    }

    public void clickContinueButton (){
        this.continueButton.click();
    }
}
