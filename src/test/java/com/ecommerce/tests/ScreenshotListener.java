package com.ecommerce.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    private static ExtentReports extentReports =
            ExtentReportManager.getReportInstance();

    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = extentReports.createTest(
                result.getMethod().getMethodName()
        );

        extentTest.set(test);

        extentTest.get().log(
                Status.INFO,
                "Test execution started."
        );

        System.out.println(
                "Test Started: " + result.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().log(
                Status.PASS,
                "Test Passed Successfully."
        );

        System.out.println(
                "Test Passed: " + result.getName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().log(
                Status.FAIL,
                "Test Failed: " + result.getThrowable()
        );

        System.out.println(
                "Test Failed: " + result.getName()
        );

        Object testInstance = result.getInstance();

        if (testInstance instanceof BaseTest) {

            BaseTest baseTest = (BaseTest) testInstance;

            WebDriver driver = baseTest.driver;

            String screenshotPath =
                    ScreenshotUtility.captureScreenshot(
                            driver,
                            result.getName()
                    );

            if (screenshotPath != null) {

                try {
                    extentTest.get().addScreenCaptureFromPath(
                            screenshotPath
                    );

                    System.out.println(
                            "Screenshot attached to Extent Report."
                    );

                } catch (Exception e) {

                    System.out.println(
                            "Unable to attach screenshot to report."
                    );

                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().log(
                Status.SKIP,
                "Test Skipped: " + result.getThrowable()
        );

        System.out.println(
                "Test Skipped: " + result.getName()
        );
    }

    @Override
    public void onFinish(
            org.testng.ITestContext context) {

        extentReports.flush();

        extentTest.remove();

        System.out.println(
                "Extent Report Generated Successfully."
        );
    }
}
