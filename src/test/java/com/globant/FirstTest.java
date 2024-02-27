package com.globant;

import com.globant.pages.BasePage;
import com.globant.pages.HomePage;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.Duration;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    private WebDriver driver;
    private BasePage basePage;
    private HomePage homePage;

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

//    @Test(dependsOnMethods = {"login"})
//    public void buyProduct() {
//        // Espera implícita con FluentWait para esperar a que estén presentes todos los elementos de la página
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
//        // Una vez que todos los elementos estén presentes, puedes continuar con tu acción
//        List<WebElement> products = driver.findElements(By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory"));
//        for (WebElement product : products) {
//            product.click();
//        }
//        wait.until(driver -> {
//            driver.findElements(By.xpath("//*")); // Seleccionar todos los elementos de la página
//            return true;
//        });
//        WebElement shoppingCartBadge = driver.findElement(By.cssSelector("a.shopping_cart_link > span.shopping_cart_badge"));
//        shoppingCartBadge.click();
//
//
//
//        wait.until(driver -> {
//            driver.findElements(By.xpath("//*")); // Seleccionar todos los elementos de la página
//            return true;
//        });
//        WebElement checkoutButton = driver.findElement(By.id("checkout"));
//        checkoutButton.click();
//
//        wait.until(driver -> {
//            driver.findElements(By.xpath("//*")); // Seleccionar todos los elementos de la página
//            return true;
//        });
//
//        WebElement firstNameField = driver.findElement(By.id("first-name"));
//        firstNameField.sendKeys("Omar");
//        WebElement lastNameField = driver.findElement(By.id("last-name"));
//        lastNameField.sendKeys("Felipe");
//        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
//        postalCodeField.sendKeys("11029");
//
//        WebElement continueButton = driver.findElement(By.id("continue"));
//        continueButton.click();
//
//        wait.until(driver -> {
//            driver.findElements(By.xpath("//*")); // Seleccionar todos los elementos de la página
//            return true;
//        });
//
//        WebElement finishButton = driver.findElement(By.id("finish"));
//        finishButton.click();
//
//
//        WebElement thankYouMessage = driver.findElement(By.cssSelector("h2.complete-header"));
//        String actualMessage = thankYouMessage.getText();
//        String expectedMessage = "Thank you for your order!";
//        Assert.assertEquals(actualMessage, expectedMessage, "El mensaje no coincide con 'Thank you for your order!'");
//    }

//    @Test(dependsOnMethods = {"login"})
//    public void removeProducts() {
//        List<WebElement> products = driver.findElements(By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory"));
//        for (int i = 0; i < 3; i++) {
//            products.get(i).click();
//        }
//
//        Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofSeconds(5))
//                .ignoring(NoSuchElementException.class);
//
//        wait.until(driver -> {
//            driver.findElements(By.xpath("//*")); // Seleccionar todos los elementos de la página
//            return true;
//        });
//        WebElement shoppingCartBadge = driver.findElement(By.cssSelector("a.shopping_cart_link > span.shopping_cart_badge"));
//        shoppingCartBadge.click();
//        wait.until(driver -> {
//            driver.findElements(By.xpath("//*")); // Seleccionar todos los elementos de la página
//            return true;
//        });
//        List<WebElement> removeButtons = driver.findElements(By.cssSelector("button.btn.btn_secondary.btn_small.cart_button"));
//        for (WebElement removeButton: removeButtons){
//            removeButton.click();
//        }
//
//        removeButtons = driver.findElements(By.cssSelector("button.btn.btn_secondary.btn_small.cart_button"));
//        Assert.assertTrue(removeButtons.isEmpty(), "El carrito no está vacío.");
//    }


    @Test(dependsOnMethods = {"login"})
    public void logOut() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        // Esperar a que estén presentes todos los elementos de la página
        wait.until(driver -> {
            driver.findElements(By.xpath("//*")); // Seleccionar todos los elementos de la página
            return true;
        });

        WebElement showMenu = driver.findElement(By.id("react-burger-menu-btn"));
        showMenu.click();


        wait.until(driver -> {
            driver.findElements(By.xpath("//*")); // Seleccionar todos los elementos de la página
            return true;
        });

        WebElement logOut = driver.findElement(By.id("logout_sidebar_link"));
        logOut.click();

    }


    @AfterClass
    public void close() {
        driver.manage().window().minimize();
    }

}
