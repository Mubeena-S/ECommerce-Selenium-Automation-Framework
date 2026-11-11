package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest extends BaseTest {

    @Test
    public void dragAndDropTest() {

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(
            By.id("column-a")
        );

        WebElement target = driver.findElement(
            By.id("column-b")
        );

        Actions actions = new Actions(driver);

        actions.clickAndHold(source)
               .moveToElement(target)
               .release()
               .perform();

        String columnA = driver.findElement(
            By.cssSelector("#column-a header")
        ).getText();

        Assert.assertEquals(
            columnA,
            "B",
            "Column A should contain B after drag and drop"
        );

        System.out.println("Drag And Drop Test Passed.");
    }
}
