package com.globant.cases;

import com.globant.commons.Data;
import com.globant.commons.TestMsgs;
import com.globant.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;

public class FirstTest {

    private WebDriver driver;
    private HomePage homePage;
    private CartPage cartPage;
    private PersonalInfoPage personalInfoPage;
    private OverviewPage overviewPage;

    private ProductsPage productsPage;

    @BeforeMethod
    public void testSetup() {
        String projectPath = System.getProperty("user.dir");
        String chromeDriverPath = projectPath + File.separator + "drivers" + File.separator + "chromedriver.exe";
        System.setProperty(Data.CHROME_DRIVER.getValue(), chromeDriverPath);
        driver = new ChromeDriver();
        homePage = new HomePage(driver, Data.URL.getValue());
        login();

    }

    public void login() {
        homePage.setCredentials(Data.USERNAME.getValue(), Data.PASSWORD.getValue());
    }

    @Test
    public void buyProduct() {
        productsPage = new ProductsPage(driver, driver.getCurrentUrl());
        productsPage.addProducts(3);
        productsPage.goToCart();

        cartPage = new CartPage(driver, driver.getCurrentUrl());
        cartPage.clickCheckout();

        personalInfoPage = new PersonalInfoPage(driver, driver.getCurrentUrl());
        personalInfoPage.setPersonalInfo(Data.FIRST_NAME.getValue(), Data.LAST_NAME.getValue(), Data.POSTAL_CODE.getValue());
        personalInfoPage.clickContinueButton();

        overviewPage = new OverviewPage(driver, driver.getCurrentUrl());
        overviewPage.clickFinishButton();
        Assert.assertEquals(overviewPage.getFinishMessage(), TestMsgs.ORDER_MESSAGE.getValue(), TestMsgs.BUY_ERROR_MESSAGE.getValue());
    }




    @Test
    public void removeProducts(){
        productsPage = new ProductsPage(driver, driver.getCurrentUrl());
        productsPage.addProducts(3);
        productsPage.goToCart();

        cartPage = new CartPage(driver, driver.getCurrentUrl());
        cartPage.clickRemoveButtons();

        cartPage.setRemoveButtons(cartPage.getRemoveButtons());
        Assert.assertTrue(cartPage.getRemoveButtons().isEmpty(), TestMsgs.REMOVE_ERROR_MESSAGE.getValue());
    }



    @Test
    public void logOut (){
        productsPage = new ProductsPage(driver, driver.getCurrentUrl());
        productsPage.openMenu();

        productsPage.waitAllElements();

        productsPage.clickLogOut();

        homePage = new HomePage(driver, driver.getCurrentUrl());
        Assert.assertTrue(homePage.loginButtonAble(), TestMsgs.LOGOUT_ERROR_MESSAGE.getValue());

    }





    @AfterMethod
    public void close() {
        driver.quit();
    }

}
