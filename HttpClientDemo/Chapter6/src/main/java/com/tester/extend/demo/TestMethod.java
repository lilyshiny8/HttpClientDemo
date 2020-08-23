package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethod {
    @Test
    public void test1() {
        Assert.assertEquals(1,2);
    }
    @Test
    public void test2() {
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3() {
        Assert.assertEquals(1,1);
    }
    @Test
    public void logDemo() {
        Reporter.log("the log I write");
        throw new RuntimeException("error I throw");
    }
}
