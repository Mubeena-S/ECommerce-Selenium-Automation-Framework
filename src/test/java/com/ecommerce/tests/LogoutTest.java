package com.ecommerce.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Verify Products Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.className("title")
        ));

        // Step 3: Open Menu
        wait.until(ExpectedConditions.elementToBeClickable(
            By.id("react-burger-menu-btn")
        )).click();

        // Step 4: Click Logout
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
        wait.until(ExpectedConditions.elementToBeClickable(
            By.id("logout_sidebar_link")
        )).click();

        // Step 5: Verify Login Page
        boolean loginButtonDisplayed = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("login-button")
            )
        ).isDisplayed();

        Assert.assertTrue(
            loginButtonDisplayed,
            "Logout was not successful!"
        );

        Assert.assertTrue(
            driver.getCurrentUrl().contains("saucedemo.com"),
            "User was not redirected to login page!"
        );

        System.out.println("Logout Test Passed.");
    }
}