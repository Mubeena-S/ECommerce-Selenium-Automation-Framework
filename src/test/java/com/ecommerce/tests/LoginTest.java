package com.ecommerce.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void validLoginTest() {

        loginPage = new LoginPage(driver);

        System.out.println("Executing Valid Login Test...");

        loginPage.login("standard_user", "secret_sauce");

        WebDriverWait wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        );

        boolean urlLoaded = wait.until(
            ExpectedConditions.urlContains("inventory.html")
        );

        Assert.assertTrue(
            urlLoaded,
            "Inventory page should open after successful login"
        );

        System.out.println("Valid Login Test Passed.");
    }

    @Test
    public void invalidPasswordTest() {

        loginPage = new LoginPage(driver);

        System.out.println("Executing Invalid Password Test...");

        loginPage.login("standard_user", "wrong_pass");

        Assert.assertTrue(
            loginPage.isErrorMessageDisplayed(),
            "Error message should be displayed"
        );

        Assert.assertTrue(
            loginPage.getErrorMessage().contains(
                "Username and password do not match"
            ),
            "Error message should be correct"
        );

        System.out.println("Invalid Password Test Passed.");
    }
}