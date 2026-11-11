package com.ecommerce.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getReportInstance() {

        if (extentReports == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            sparkReporter.config().setDocumentTitle(
                    "E-Commerce Automation Report"
            );

            sparkReporter.config().setReportName(
                    "SauceDemo Test Execution Report"
            );

            extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo("Application", "SauceDemo");
            extentReports.setSystemInfo("Automation Tool", "Selenium");
            extentReports.setSystemInfo("Testing Framework", "TestNG");
            extentReports.setSystemInfo("Programming Language", "Java");

        }

        return extentReports;
    }
}
