package com.ecommerce.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyboardActionsTest extends BaseTest {

    @Test
    public void keyboardOperationsTest() {

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

        // Step 1: Open Login Page
        driver.get("https://the-internet.herokuapp.com/login");

        // Step 2: Locate Username
        WebElement username = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("username")
            )
        );

        // Step 3: Enter Username Using Keyboard
        Actions actions = new Actions(driver);

        actions.click(username)
               .keyDown(org.openqa.selenium.Keys.CONTROL)
               .sendKeys("a")
               .keyUp(org.openqa.selenium.Keys.CONTROL)
               .sendKeys("tomsmith")
               .sendKeys(org.openqa.selenium.Keys.TAB)
               .sendKeys("SuperSecretPassword!")
               .sendKeys(org.openqa.selenium.Keys.ENTER)
               .perform();

        // Step 4: Wait For Login Result
        WebElement message = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("flash")
            )
        );

        // Step 5: Verify Login
        Assert.assertTrue(
            message.getText().contains(
                "You logged into a secure area!"
            )
        );

        System.out.println("Keyboard Operations Test Passed.");
    }
}