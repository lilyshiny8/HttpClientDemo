package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "group1")
    public void test1() {
        System.out.println("test1");
    }
    @Test(groups = "group1")
    public void test2() {
        System.out.println("test2");
    }
    @Test(groups = "group2")
    public void test3() {
        System.out.println("test3");
    }
    @BeforeGroups("group1")
    public void beforeGroupOnGroup1() {
        System.out.println("before group1");
    }
    @AfterGroups("group1")
    public void afterGroupOnGroup1() {
        System.out.println("after group1");
    }
}
