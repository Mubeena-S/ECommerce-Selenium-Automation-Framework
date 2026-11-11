package com.ecommerce.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][] {

            {"standard_user", "secret_sauce"},
            {"problem_user", "secret_sauce"},
            {"performance_glitch_user", "secret_sauce"},
            {"invalid_user", "wrong_password"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {

        System.out.println("Testing Username: " + username);
        System.out.println("Testing Password: " + password);

    }
}
