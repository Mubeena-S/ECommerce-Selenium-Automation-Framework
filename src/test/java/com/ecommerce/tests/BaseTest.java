package com.ecommerce.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        System.out.println("Starting Browser...");

        // Load Configuration
        ConfigReader.loadProperties();

        // Read Browser Configuration
        String browser = ConfigReader.getProperty("browser");

        // Launch Browser
        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else {
            throw new RuntimeException(
                "Unsupported browser: " + browser
            );
        }

        // Maximize Browser
        driver.manage().window().maximize();

        // Read Website URL
        String url = ConfigReader.getProperty("url");

        // Open Website
        driver.get(url);

        System.out.println("Website opened: " + url);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();

            System.out.println("Browser closed.");
        }
    }
}
