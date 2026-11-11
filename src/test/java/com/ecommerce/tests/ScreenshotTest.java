package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScreenshotTest extends BaseTest {

    @Test
    public void screenshotFailureTest() {

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

        // Step 1: Login
        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        // Step 2: Verify Login
        wait.until(
            ExpectedConditions.urlContains("inventory.html")
        );

        System.out.println("Login Successful.");

        // Step 3: Generate Intentional Failure
        Assert.fail(
            "Intentional failure to test screenshot automation."
        );
    }
}
