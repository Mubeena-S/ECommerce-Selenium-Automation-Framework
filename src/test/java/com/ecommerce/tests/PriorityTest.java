package com.ecommerce.tests;

import org.testng.annotations.Test;

public class PriorityTest {

    @Test(priority = 1)
    public void loginTest() {
        System.out.println("Login Test");
    }

    @Test(priority = 2)
    public void searchTest() {
        System.out.println("Search Test");
    }

    @Test(priority = 3)
    public void logoutTest() {
        System.out.println("Logout Test");
    }
}