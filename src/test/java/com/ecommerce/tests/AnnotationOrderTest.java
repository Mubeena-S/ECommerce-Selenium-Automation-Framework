package com.ecommerce.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationOrderTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("1. Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("2. Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("3. Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("4. Before Method");
    }

    @Test
    public void testOne() {
        System.out.println("5. Test One");
    }

    @Test
    public void testTwo() {
        System.out.println("5. Test Two");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("6. After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("7. After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("8. After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("9. After Suite");
    }
}
