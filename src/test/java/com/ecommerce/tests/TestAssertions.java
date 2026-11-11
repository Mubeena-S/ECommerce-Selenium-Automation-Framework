package com.ecommerce.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAssertions {

    // Lesson 42: assertEquals()

    @Test
    public void verifyTitleTest() {

        String actualTitle = "Swag Labs";
        String expectedTitle = "Swag Labs";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Title Verification Passed");
    }

    @Test
    public void verifyUsernameTest() {

        String actualUsername = "standard_user";
        String expectedUsername = "standard_user";

        Assert.assertEquals(actualUsername, expectedUsername);

        System.out.println("Username Verification Passed");
    }

    // Lesson 43: assertTrue()

    @Test
    public void verifyTitleUsingAssertTrue() {

        String actualTitle = "Swag Labs";

        Assert.assertTrue(actualTitle.contains("Swag"));

        System.out.println("AssertTrue Verification Passed");
    }

    // Lesson 43: assertFalse()

    @Test
    public void verifyInvalidLoginUsingAssertFalse() {

        boolean loginSuccess = false;

        Assert.assertFalse(loginSuccess);

        System.out.println("AssertFalse Verification Passed");
    }

    // Lesson 44: assertNull()

    @Test
    public void verifyNullValue() {

        String value = null;

        Assert.assertNull(value);

        System.out.println("Null Verification Passed");
    }

    // Lesson 44: assertNotNull()

    @Test
    public void verifyNotNullValue() {

        String value = "Automation Testing";

        Assert.assertNotNull(value);

        System.out.println("Not Null Verification Passed");
    }

    // Lesson 45: assertSame()

    @Test
    public void verifySameObject() {

        String first = "Java";
        String second = first;

        Assert.assertSame(first, second);

        System.out.println("Same Object Verification Passed");
    }

    // Lesson 45: assertNotSame()

    @Test
    public void verifyDifferentObjects() {

        String first = new String("Java");
        String second = new String("Java");

        Assert.assertNotSame(first, second);

        System.out.println("Different Object Verification Passed");
    }

    // Lesson 46: assertThrows()

    @Test
    public void verifyArithmeticException() {

        Assert.assertThrows(
            ArithmeticException.class,
            () -> {
                int result = 10 / 0;
            }
        );

        System.out.println("Exception Verification Passed");
    }

    // Lesson 47: SoftAssert

    @Test
    public void verifyMultipleConditionsUsingSoftAssert() {

        SoftAssert softAssert = new SoftAssert();

        String actualTitle = "Swag Labs";
        String actualUsername = "standard_user";

        softAssert.assertEquals(actualTitle, "Swag Labs");
        System.out.println("Title Check Executed");

        softAssert.assertEquals(actualUsername, "standard_user");
        System.out.println("Username Check Executed");

        softAssert.assertTrue(actualTitle.contains("Swag"));
        System.out.println("Text Check Executed");

        softAssert.assertAll();

        System.out.println("All Soft Assertions Passed");
    }

    // Lesson 48: Hard Assert vs Soft Assert

    @Test
    public void verifyHardAssertBehavior() {

        System.out.println("Hard Assert Test Started");

        Assert.assertThrows(
            AssertionError.class,
            () -> {
                Assert.assertEquals(
                    "Java",
                    "Python",
                    "Hard assertion failed"
                );

                System.out.println("Hard Assert Second Statement Executed");
            }
        );

        System.out.println("Hard Assert Failure Captured");
    }

    @Test
    public void verifySoftAssertBehavior() {

        SoftAssert softAssert = new SoftAssert();

        System.out.println("Soft Assert Test Started");

        softAssert.assertEquals(
            "Java",
            "Python",
            "Soft assertion failed"
        );

        System.out.println("Soft Assert Second Statement Executed");

        Assert.assertThrows(
            AssertionError.class,
            () -> softAssert.assertAll()
        );

        System.out.println("Soft Assert Failure Captured");
    }
}
