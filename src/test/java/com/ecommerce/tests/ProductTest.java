package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.LoginPage;

public class ProductTest extends BaseTest {

    @Test
    public void productPageTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        String pageTitle = driver.findElement(
            By.className("title")
        ).getText();

        Assert.assertEquals(
            pageTitle,
            "Products",
            "Product page should be displayed"
        );

        System.out.println("Product Test Passed.");
    }
}