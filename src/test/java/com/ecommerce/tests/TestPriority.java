package com.ecommerce.tests;

import org.testng.annotations.Test;

public class TestPriority {

    @Test(priority = 3)
    public void loginTest() {
        System.out.println("Login Test");
    }

    @Test(priority = 1)
    public void homePageTest() {
        System.out.println("Home Page Test");
    }

    @Test(priority = 2)
    public void searchTest() {
        System.out.println("Search Test");
    }
}
