package com.course.testng.suite;
import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }
    //对于套件测试，在运行属于<test>标签内的类的任何测试方法之前运行。
    //对于套件测试，在运行属于<test>标签内的类的所有测试方法都已运行之后运行。
    @BeforeTest
    public void beforeTest() {
        System.out.println("before test");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("after test");
    }


}
