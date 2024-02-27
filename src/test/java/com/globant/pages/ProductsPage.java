package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage{

    WebDriver driver;


    @FindBy (css = "button.btn.btn_primary.btn_small.btn_inventory")
    private List<WebElement> addButtons;

    @FindBy (css = "a.shopping_cart_link > span.shopping_cart_badge")
    private WebElement cartButton;


    public ProductsPage(WebDriver driver, String url){
        super(driver);
        driver.get(url);
    }


    public void addProducts(){
        waitAllElements();
        for (WebElement addProduct: this.addButtons){
            addProduct.click();
        }
    }

    public void goToCart(){
        this.cartButton.click();
    }

    public List<WebElement> getAddButtons() {
        return addButtons;
    }

    public void setAddButtons(List<WebElement> addButtons) {
        this.addButtons = addButtons;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public void setCartButton(WebElement cartButton) {
        this.cartButton = cartButton;
    }
}
