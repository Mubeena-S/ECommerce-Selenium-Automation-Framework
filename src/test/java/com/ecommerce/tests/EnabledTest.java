package com.ecommerce.tests;

import org.testng.annotations.Test;

public class EnabledTest {

    @Test
    public void activeTest() {
        System.out.println("Active Test");
    }

    @Test(enabled = false)
    public void disabledTest() {
        System.out.println("Disabled Test");
    }
}
