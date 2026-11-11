# E-Commerce Selenium Automation Framework

## Project Overview

This project is an End-to-End E-Commerce Automation Testing Framework developed using Java, Selenium WebDriver, TestNG, and Maven.

The framework automates important e-commerce application workflows using the SauceDemo website. It follows the Page Object Model (POM) design pattern and includes reusable test components, configuration management, screenshot capture, and HTML reporting.

## Technologies Used

- Java 17
- Selenium WebDriver 4.27.0
- TestNG
- Maven
- Page Object Model (POM)
- Extent Reports
- Git and GitHub
- Eclipse IDE

## Features

- Valid and invalid login testing
- Product page validation
- Add-to-cart and remove-from-cart testing
- Checkout workflow automation
- Logout functionality testing
- Explicit and Fluent Waits
- Mouse and keyboard actions
- Drag and drop actions
- TestNG annotations and assertions
- Configuration management using properties file
- Screenshot capture using TestNG listeners
- HTML test reporting using Extent Reports

## Project Structure

```text
ECommerceAutomation
│
├── src
│   ├── main
│   │   └── java
│   │       └── com/ecommerce/pages
│   │           └── LoginPage.java
│   │
│   └── test
│       ├── java/com/ecommerce/tests
│       │   ├── BaseTest.java
│       │   ├── LoginTest.java
│       │   ├── ProductTest.java
│       │   ├── CartTest.java
│       │   ├── CheckoutTest.java
│       │   ├── LogoutTest.java
│       │   ├── ScreenshotUtility.java
│       │   ├── ScreenshotListener.java
│       │   └── ExtentReportManager.java
│       │
│       └── resources
│           └── config.properties
│
├── reports
│   └── ExtentReport.html
│
├── screenshots
│
├── pom.xml
├── testng.xml
└── .gitignore
```

## Application Under Test

Website: https://www.saucedemo.com/

## How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/Mubeena-S/ECommerce-Selenium-Automation-Framework.git
```

2. Import the project into Eclipse as an existing Maven project.

3. Make sure Java 17 and Maven are configured.

4. Run the complete TestNG suite:

```bash
mvn test
```

## Test Execution

The project includes automated test cases for login, products, cart, checkout, logout, waits, browser interactions, and configuration.

The final verified suite execution completed with:

- Tests Run: 14
- Failures: 0
- Errors: 0
- Skipped: 0
- Build Status: SUCCESS

## Reports and Screenshots

- Extent Reports generates an HTML execution report.
- Screenshot automation captures test failure evidence.
- Reports and screenshots are maintained in the project folders.

## Author

**Mubeena S**

GitHub: https://github.com/Mubeena-S

LinkedIn: https://linkedin.com/in/mubeena-savalagi-0490a91b7
