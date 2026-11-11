package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"},
            {"wrong_user", "wrong_pass"},
            {"standard_user", "wrong_pass"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginDataTest(String username, String password) {
        Assert.assertNotNull(username);
        Assert.assertNotNull(password);

        System.out.println("Testing username: " + username);
    }
}
