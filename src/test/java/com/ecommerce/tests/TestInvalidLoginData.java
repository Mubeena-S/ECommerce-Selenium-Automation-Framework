package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestInvalidLoginData {

    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData() {

        return new Object[][] {
            {"wrong_user", "secret_sauce"},
            {"standard_user", "wrong_password"},
            {"wrong_user", "wrong_password"}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void invalidLoginTest(String username, String password) {

        System.out.println("Testing Username: " + username);
        System.out.println("Testing Password: " + password);

        boolean loginSuccessful = false;

        Assert.assertFalse(
            loginSuccessful,
            "Invalid login should not be successful"
        );
    }
}
