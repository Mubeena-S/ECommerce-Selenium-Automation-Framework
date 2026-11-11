package com.ecommerce.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.LoginPage;

public class WaitTest extends BaseTest {

    @Test
    public void fluentWaitTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        driver.findElement(
            By.id("add-to-cart-sauce-labs-backpack")
        ).click();

        Wait<org.openqa.selenium.WebDriver> wait =
            new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        String cartCount = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.className("shopping_cart_badge")
            )
        ).getText();

        Assert.assertEquals(cartCount, "1");

        System.out.println("Fluent Wait Test Passed.");
    }
}