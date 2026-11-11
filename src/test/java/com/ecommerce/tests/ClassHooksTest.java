package com.ecommerce.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ClassHooksTest {

    @BeforeClass
    public void setUp() {
        System.out.println("Before Class");
    }

    @Test
    public void firstTest() {
        System.out.println("First Test");
    }

    @Test
    public void secondTest() {
        System.out.println("Second Test");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After Class");
    }
}
