package com.ecommerce.tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

    @BeforeClass
    public void setupClass() {

        System.out.println("BeforeClass: Class Setup");
    }

    @BeforeMethod
    public void setupMethod() {

        System.out.println("BeforeMethod: Test Setup");
    }

    @Test
    public void verifyLogin() {

        System.out.println("Test Case 1: Login Verification");
    }

    @Test
    public void verifyHomePage() {

        System.out.println("Test Case 2: Home Page Verification");
    }

    @AfterMethod
    public void tearDownMethod() {

        System.out.println("AfterMethod: Test Cleanup");
    }

    @AfterClass
    public void tearDownClass() {

        System.out.println("AfterClass: Class Cleanup");
    }
}
