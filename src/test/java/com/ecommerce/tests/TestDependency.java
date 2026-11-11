package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDependency {

    @Test
    public void loginTest() {

        System.out.println("Login Test Executed");

        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void dashboardTest() {

        System.out.println("Dashboard Test Executed");
    }

    @Test(dependsOnMethods = {"dashboardTest"})
    public void logoutTest() {

        System.out.println("Logout Test Executed");
    }
}
