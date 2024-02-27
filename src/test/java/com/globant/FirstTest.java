package com.globant;

import com.globant.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

    @BeforeClass
    public void testSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\omar.ladino\\Documents\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        homePage = new HomePage(driver, "https://www.saucedemo.com/");
    }

    @Test
    public void login() {
        homePage.setCredentials("standard_user", "secret_sauce");
    }

    @Test(dependsOnMethods = {"login"})
    public void buyProduct() {
        productsPage = new ProductsPage(driver, driver.getCurrentUrl());
        productsPage.addProducts(6);
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



    @Test(dependsOnMethods = {"login"})
    public void removeProducts(){
        productsPage = new ProductsPage(driver, driver.getCurrentUrl());
        productsPage.addProducts(3);
        productsPage.goToCart();

        cartPage = new CartPage(driver, driver.getCurrentUrl());
        cartPage.clickRemoveButtons();

        cartPage.setRemoveButtons(cartPage.getRemoveButtons());
        Assert.assertTrue(cartPage.getRemoveButtons().isEmpty(), "Shopping cart is not empty.");
    }


//    @Test(dependsOnMethods = {"login"})
//    public void logOut() {
//        Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofSeconds(5))
//                .ignoring(NoSuchElementException.class);
//
//        // Esperar a que estén presentes todos los elementos de la página
//        wait.until(driver -> {
//            driver.findElements(By.xpath("//*")); // Seleccionar todos los elementos de la página
//            return true;
//        });
//
//        WebElement showMenu = driver.findElement(By.id("react-burger-menu-btn"));
//        showMenu.click();
//
//
//        wait.until(driver -> {
//            driver.findElements(By.xpath("//*")); // Seleccionar todos los elementos de la página
//            return true;
//        });
//
//        WebElement logOut = driver.findElement(By.id("logout_sidebar_link"));
//        logOut.click();
//
//    }


    @AfterClass
    public void close() {
        driver.manage().window().minimize();
    }

}
