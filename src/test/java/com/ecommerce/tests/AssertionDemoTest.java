package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemoTest {

    @Test
    public void passingAssertionTest() {
        Assert.assertTrue(true, "Condition true honi chahiye");
    }
}
