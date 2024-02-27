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

    @FindBy (id = "react-burger-menu-btn")
    private WebElement showMenu;

    @FindBy (id = "logout_sidebar_link")
    private WebElement logOut;


    public ProductsPage(WebDriver driver, String url){
        super(driver);
        driver.get(url);
    }


    public void addProducts(int n){
        waitAllElements();

        for (int i = 0; i < n; i++) {
            System.out.println(addButtons.size()+"  "+i);
            this.addButtons.get(i).click();
        }
    }

    public void goToCart(){
        this.cartButton.click();
    }

    public void openMenu (){
        waitAllElements();
        this.showMenu.click();
    }

    public void clickLogOut (){
        waitAllElements();
        this.logOut.click();
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
