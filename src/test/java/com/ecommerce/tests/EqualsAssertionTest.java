package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EqualsAssertionTest {

    @Test
    public void checkTitleTest() {
        String actualTitle = "Products";
        String expectedTitle = "Products";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void checkMessageTest() {
        String actualMessage = "Login successful";
        String expectedMessage = "Login successful";

        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
