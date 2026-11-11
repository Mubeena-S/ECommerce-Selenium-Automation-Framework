package com.ecommerce.tests;

import org.testng.annotations.Test;

public class TestNGPriority {

    @Test(priority = 1)
    public void loginTest() {

        System.out.println("Priority 1: Login Test");
    }

    @Test(priority = 2)
    public void productTest() {

        System.out.println("Priority 2: Product Test");
    }

    @Test(priority = 3)
    public void addToCartTest() {

        System.out.println("Priority 3: Add To Cart Test");
    }

    @Test(priority = 4)
    public void checkoutTest() {

        System.out.println("Priority 4: Checkout Test");
    }
}
