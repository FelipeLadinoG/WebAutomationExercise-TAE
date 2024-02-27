package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    WebDriver driver;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(css = "button.btn.btn_secondary.btn_small.cart_button")
    private List<WebElement> removeButtons;


    public CartPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public void clickCheckout() {
        waitAllElements();
        this.checkoutButton.click();
    }

    public void clickRemoveButtons() {
        for (WebElement removeButton : removeButtons) {
            removeButton.click();
        }
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public void setCheckoutButton(WebElement checkoutButton) {
        this.checkoutButton = checkoutButton;
    }

    public List<WebElement> getRemoveButtons() {
        return removeButtons;
    }

    public void setRemoveButtons(List<WebElement> removeButtons) {
        this.removeButtons = removeButtons;
    }
}
