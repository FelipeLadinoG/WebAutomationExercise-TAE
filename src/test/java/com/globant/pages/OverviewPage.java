package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {

    WebDriver driver;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(css = "h2.complete-header")
    private WebElement completeHeader;


    public OverviewPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }


    public void clickFinishButton() {
        this.finishButton.click();
    }

    public boolean sameCompleteMessage(String message) {
        waitAllElements();
        return this.completeHeader.getText().equals(message);
    }

    public String getFinishMessage (){
        return this.completeHeader.getText();
    }
}
