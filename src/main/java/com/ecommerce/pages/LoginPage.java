package com.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(10)
        );
    }

    public void enterUsername(String user) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(username)
        ).sendKeys(user);
    }

    public void enterPassword(String pass) {
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(password)
        ).sendKeys(pass);
    }

    public void clickLogin() {
        wait.until(
            ExpectedConditions.elementToBeClickable(loginButton)
        ).click();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public String getErrorMessage() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(errorMessage)
        ).getText();
    }

    public boolean isErrorMessageDisplayed() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(errorMessage)
        ).isDisplayed();
    }
}