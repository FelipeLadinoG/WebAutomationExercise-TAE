package com.globant;

import com.globant.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import java.util.NoSuchElementException;

public class FirstTest {

    private WebDriver driver;
    private BasePage basePage;
    private HomePage homePage;
    private CartPage cartPage;
    private PersonalInfoPage personalInfoPage;
    private OverviewPage overviewPage;

    private ProductsPage productsPage;

    @BeforeMethod
    public void testSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\omar.ladino\\Documents\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        homePage = new HomePage(driver, "https://www.saucedemo.com/");
        login();

    }

    public void login() {
        homePage.setCredentials("standard_user", "secret_sauce");
    }

    @Test
    public void buyProduct() {
        productsPage = new ProductsPage(driver, driver.getCurrentUrl());
        productsPage.addProducts(3);
        productsPage.goToCart();

        cartPage = new CartPage(driver, driver.getCurrentUrl());
        cartPage.clickCheckout();

        personalInfoPage = new PersonalInfoPage(driver, driver.getCurrentUrl());
        personalInfoPage.setPersonalInfo("omar", "felipe","12345");
        personalInfoPage.clickContinueButton();

        overviewPage = new OverviewPage(driver, driver.getCurrentUrl());
        overviewPage.clickFinishButton();
        Assert.assertEquals(overviewPage.getFinishMessage(), "Thank you for your order!", "El mensaje no coincide con 'Thank you for your order!'");
    }




    @Test
    public void removeProducts(){
        productsPage = new ProductsPage(driver, driver.getCurrentUrl());
        productsPage.addProducts(3);
        productsPage.goToCart();

        cartPage = new CartPage(driver, driver.getCurrentUrl());
        cartPage.clickRemoveButtons();

        cartPage.setRemoveButtons(cartPage.getRemoveButtons());
        Assert.assertTrue(cartPage.getRemoveButtons().isEmpty(), "Shopping cart is not empty.");
    }



    @Test
    public void logOut (){
        productsPage = new ProductsPage(driver, driver.getCurrentUrl());
        productsPage.openMenu();
        productsPage.clickLogOut();

        homePage = new HomePage(driver, driver.getCurrentUrl());
        Assert.assertTrue(homePage.loginButtonAble(), "Login failed.");

    }





    @AfterMethod
    public void close() {
        driver.manage().window().minimize();
    }

}
