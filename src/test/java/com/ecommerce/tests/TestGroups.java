package com.ecommerce.tests;

import org.testng.annotations.Test;

public class TestGroups {

    @Test(groups = {"smoke"})
    public void loginTest() {
        System.out.println("Login Smoke Test");
    }

    @Test(groups = {"regression"})
    public void paymentTest() {
        System.out.println("Payment Regression Test");
    }

    @Test(groups = {"smoke", "regression"})
    public void checkoutTest() {
        System.out.println("Checkout Test");
    }
}
