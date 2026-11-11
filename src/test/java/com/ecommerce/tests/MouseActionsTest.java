package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseActionsTest extends BaseTest {

    @Test
    public void mouseHoverTest() {

        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement profile = driver.findElement(
            By.xpath("(//div[@class='figure'])[1]")
        );

        Actions actions = new Actions(driver);

        actions.moveToElement(profile).perform();

        WebElement userName = driver.findElement(
            By.xpath("(//div[@class='figcaption']/h5)[1]")
        );

        Assert.assertTrue(userName.isDisplayed());

        System.out.println("Mouse Hover Test Passed.");
    }

    @Test
    public void rightClickTest() {

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = driver.findElement(
            By.id("hot-spot")
        );

        Actions actions = new Actions(driver);

        actions.contextClick(box).perform();

        String alertText = driver.switchTo().alert().getText();

        Assert.assertEquals(alertText, "You selected a context menu");

        driver.switchTo().alert().accept();

        System.out.println("Right Click Test Passed.");
    }
}
