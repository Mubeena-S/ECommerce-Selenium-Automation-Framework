package com.ecommerce.tests;

import org.testng.annotations.Test;

public class DependencyTest {

    @Test
    public void loginTest() {
        System.out.println("Login Test Passed");
    }

    @Test(dependsOnMethods = "loginTest")
    public void searchTest() {
        System.out.println("Search Test Passed");
    }

    @Test(dependsOnMethods = "searchTest")
    public void logoutTest() {
        System.out.println("Logout Test Passed");
    }
}
