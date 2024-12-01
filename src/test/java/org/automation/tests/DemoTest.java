package org.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {

    @Test
    public void demoTest1() {
        System.out.println("It is test 1");
        Assert.assertTrue(true,"Test 1 failed");
    }

    @Test
    public void demoTest2() {
        System.out.println("It is test 2");
        Assert.assertTrue(false,"Test 2 failed");
    }

    @Test
    public void demoTest3() {
        System.out.println("It is test 3");
        Assert.assertTrue(false,"Test 3 failed");
    }

}
