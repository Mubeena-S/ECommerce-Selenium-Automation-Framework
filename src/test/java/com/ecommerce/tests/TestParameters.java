package com.ecommerce.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {

    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

    }
}
