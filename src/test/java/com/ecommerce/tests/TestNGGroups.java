
package com.ecommerce.tests;

import org.testng.annotations.Test;

public class TestNGGroups {

    @Test(groups = {"smoke"})
    public void loginTest() {

        System.out.println("Smoke: Login Test");
    }

    @Test(groups = {"smoke"})
    public void productTest() {

        System.out.println("Smoke: Product Test");
    }

    @Test(groups = {"regression"})
    public void addToCartTest() {

        System.out.println("Regression: Add To Cart Test");
    }

    @Test(groups = {"regression"})
    public void checkoutTest() {

        System.out.println("Regression: Checkout Test");
    }

    @Test(groups = {"smoke", "regression"})
    public void logoutTest() {

        System.out.println("Smoke and Regression: Logout Test");
    }
}
