package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigTest {

    @Test
    public void configurationTest() {

        ConfigReader.loadProperties();

        String url = ConfigReader.getProperty("url");
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        String browser = ConfigReader.getProperty("browser");

        Assert.assertNotNull(url);
        Assert.assertNotNull(username);
        Assert.assertNotNull(password);
        Assert.assertNotNull(browser);

        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Browser: " + browser);

        System.out.println("Configuration Test Passed.");
    }
}