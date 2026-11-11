package com.ecommerce.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static String captureScreenshot(
            WebDriver driver, String testName) {

        if (driver == null) {
            System.out.println("Screenshot unavailable: Driver is null.");
            return null;
        }

        try {
            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Path screenshotFolder = Paths.get(
                    System.getProperty("user.dir"),
                    "screenshots"
            );

            Files.createDirectories(screenshotFolder);

            String fileName = testName + "_"
                    + System.currentTimeMillis() + ".png";

            Path destination = screenshotFolder.resolve(fileName);

            Files.copy(
                    source.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

            String screenshotPath = destination.toAbsolutePath().toString();

            System.out.println(
                    "Screenshot saved: " + screenshotPath
            );

            return screenshotPath;

        } catch (IOException e) {

            System.out.println("Unable to save screenshot.");
            e.printStackTrace();

            return null;
        }
    }
}
