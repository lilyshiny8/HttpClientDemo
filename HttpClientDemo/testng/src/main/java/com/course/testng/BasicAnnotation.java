package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    //用来把方法标记为测试的一部分
    @Test(enabled = true)
    public void testCase1() {
        System.out.println("test case 1 is executed");
    }
    @Test(enabled = false)
    public void testCase2() {
        System.out.println("test case 2 is executed");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }


}
