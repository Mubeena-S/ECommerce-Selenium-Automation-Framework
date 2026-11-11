package com.ecommerce.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSuiteAnnotations {

    @BeforeSuite
    public void setupSuite() {

        System.out.println("BeforeSuite: Suite Setup");
    }

    @BeforeTest
    public void setupTest() {

        System.out.println("BeforeTest: XML Test Setup");
    }

    @Test
    public void verifyProductPage() {

        System.out.println("Test Case 1: Product Page Verification");
    }

    @Test
    public void verifyCartPage() {

        System.out.println("Test Case 2: Cart Page Verification");
    }

    @AfterTest
    public void tearDownTest() {

        System.out.println("AfterTest: XML Test Cleanup");
    }

    @AfterSuite
    public void tearDownSuite() {

        System.out.println("AfterSuite: Suite Cleanup");
    }
}
