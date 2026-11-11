package com.ecommerce.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutTest() {

        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(20)
        );

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Add Product To Cart
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("add-to-cart-sauce-labs-backpack")
        )).click();

        // Step 3: Open Cart
        wait.until(ExpectedConditions.elementToBeClickable(
                By.className("shopping_cart_link")
        )).click();

        // Step 4: Verify Product
        String productName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("inventory_item_name")
                )
        ).getText();

        Assert.assertEquals(productName, "Sauce Labs Backpack");

        // Step 5: Click Checkout
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("checkout")
        )).click();

        // Step 6: Verify Checkout Information Page
        wait.until(ExpectedConditions.urlContains(
                "checkout-step-one.html"
        ));

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        System.out.println("Page Source Contains First Name: "
                + driver.getPageSource().contains("first-name"));

        // Step 7: Locate Customer Information Fields
        WebElement firstName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("first-name")
                )
        );

        WebElement lastName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("last-name")
                )
        );

        WebElement postalCode = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("postal-code")
                )
        );

        // Step 8: Enter Customer Information
        firstName.sendKeys("John");
        lastName.sendKeys("Smith");
        postalCode.sendKeys("560001");

        // Step 9: Verify Entered Information
        Assert.assertEquals(
                firstName.getDomProperty("value"), "John"
        );

        Assert.assertEquals(
                lastName.getDomProperty("value"), "Smith"
        );

        Assert.assertEquals(
                postalCode.getDomProperty("value"), "560001"
        );

        System.out.println("Customer Information Entered Successfully.");

        // Step 10: Continue
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("continue")
        )).click();

        // Step 11: Verify Checkout Overview
        wait.until(ExpectedConditions.urlContains(
                "checkout-step-two.html"
        ));

        System.out.println("Checkout Overview Page Opened.");

        // Step 12: Finish Order
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("finish")
        )).click();

        // Step 13: Verify Order Confirmation
        String confirmationMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("complete-header")
                )
        ).getText();

        Assert.assertEquals(
                confirmationMessage,
                "Thank you for your order!"
        );

        System.out.println("Complete Checkout Test Passed.");
    }
}
