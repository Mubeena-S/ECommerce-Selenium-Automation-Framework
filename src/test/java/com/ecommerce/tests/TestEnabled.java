package com.ecommerce.tests;

import org.testng.annotations.Test;

public class TestEnabled {

    @Test
    public void loginTest() {
        System.out.println("Login Test Executed");
    }

    @Test(enabled = false)
    public void paymentTest() {
        System.out.println("Payment Test Executed");
    }

    @Test
    public void logoutTest() {
        System.out.println("Logout Test Executed");
    }
}
