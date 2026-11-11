package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParametersTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce", true},
            {"standard_user", "wrong_pass", false},
            {"wrong_user", "secret_sauce", false}
        };
    }

    @Test(dataProvider = "loginData")
    public void checkLoginData(
            String username,
            String password,
            boolean shouldLoginSucceed) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name"))
                  .sendKeys(username);

            driver.findElement(By.id("password"))
                  .sendKeys(password);

            driver.findElement(By.id("login-button")).click();

            if (shouldLoginSucceed) {
                Assert.assertTrue(
                    driver.getCurrentUrl().contains("inventory.html"),
                    "Valid login should succeed"
                );
            } else {
                String errorMessage = driver.findElement(
                    By.cssSelector("[data-test='error']")
                ).getText();

                Assert.assertTrue(
                    errorMessage.length() > 0,
                    "Invalid login should show an error message"
                );
            }

        } finally {
            driver.quit();
        }
    }
}
