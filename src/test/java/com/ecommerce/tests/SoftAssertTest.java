package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

    @Test
    public void hardAssertExample() {

        System.out.println("Hard Assert Test Started");

        Assert.assertEquals(10, 20);

        System.out.println("This line will not execute");
    }

    @Test
    public void softAssertExample() {

        SoftAssert softAssert = new SoftAssert();

        System.out.println("Soft Assert Test Started");

        softAssert.assertEquals(10, 20);

        System.out.println("This line will execute");

        softAssert.assertEquals("Login", "Dashboard");

        System.out.println("All checks completed");

        softAssert.assertAll();
    }
}
