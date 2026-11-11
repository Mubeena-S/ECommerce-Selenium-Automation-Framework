package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.LoginPage;

public class ActionsTest extends BaseTest {

    @Test
    public void doubleClickTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        WebElement product = driver.findElement(
            By.className("title")
        );

        Actions actions = new Actions(driver);

        actions.doubleClick(product).perform();

        Assert.assertEquals(product.getText(), "Products");

        System.out.println("Double Click Test Passed.");
    }

    @Test
    public void keyboardActionTest() {

        WebElement username = driver.findElement(
            By.id("user-name")
        );

        Actions actions = new Actions(driver);

        actions.click(username)
               .sendKeys("standard_user")
               .sendKeys(Keys.TAB)
               .sendKeys("secret_sauce")
               .perform();

        String enteredUsername = username.getAttribute("value");

        Assert.assertEquals(enteredUsername, "standard_user");

        System.out.println("Keyboard Action Test Passed.");
    }
}