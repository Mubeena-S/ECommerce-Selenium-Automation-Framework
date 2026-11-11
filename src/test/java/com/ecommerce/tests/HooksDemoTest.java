package com.ecommerce.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HooksDemoTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("Test start hone se pehle");
    }

    @Test
    public void firstTest() {
        System.out.println("First test running");
    }

    @Test
    public void secondTest() {
        System.out.println("Second test running");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Test complete hone ke baad");
    }
}