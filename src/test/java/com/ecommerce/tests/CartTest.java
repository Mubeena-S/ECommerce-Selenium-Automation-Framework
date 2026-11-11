package com.ecommerce.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        driver.findElement(
            By.id("add-to-cart-sauce-labs-backpack")
        ).click();

        driver.findElement(
            By.className("shopping_cart_link")
        ).click();

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );

        WebElement product = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.className("inventory_item_name")
            )
        );

        String productName = product.getText();

        Assert.assertEquals(
            productName,
            "Sauce Labs Backpack",
            "Product should be added to cart"
        );

        System.out.println("Add To Cart Test Passed.");
    }
}
