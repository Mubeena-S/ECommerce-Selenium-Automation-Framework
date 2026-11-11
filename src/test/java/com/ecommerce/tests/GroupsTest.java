package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class GroupsTest {

    @Test(groups = {"checkout"})
    public void checkoutTest() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name"))
                  .sendKeys("standard_user");

            driver.findElement(By.id("password"))
                  .sendKeys("secret_sauce");

            driver.findElement(By.id("login-button")).click();

            Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login should be successful"
            );

            driver.findElement(
                By.id("add-to-cart-sauce-labs-backpack")
            ).click();

            driver.findElement(
                By.className("shopping_cart_link")
            ).click();

            Assert.assertEquals(
                driver.findElement(
                    By.className("inventory_item_name")
                ).getText(),
                "Sauce Labs Backpack",
                "Cart should contain the selected product"
            );

            driver.findElement(By.id("checkout")).click();

            driver.findElement(By.id("first-name"))
                  .sendKeys("Test");

            driver.findElement(By.id("last-name"))
                  .sendKeys("User");

            driver.findElement(By.id("postal-code"))
                  .sendKeys("560001");

            driver.findElement(By.id("continue")).click();

            WebElement summaryProduct = driver.findElement(
                By.className("inventory_item_name")
            );

            Assert.assertEquals(
                summaryProduct.getText(),
                "Sauce Labs Backpack",
                "Checkout summary should show the selected product"
            );

            driver.findElement(By.id("finish")).click();

            WebElement confirmation = driver.findElement(
                By.className("complete-header")
            );

            Assert.assertEquals(
                confirmation.getText(),
                "Thank you for your order!",
                "Order should be completed successfully"
            );

        } finally {
            driver.quit();
        }
    }
}
