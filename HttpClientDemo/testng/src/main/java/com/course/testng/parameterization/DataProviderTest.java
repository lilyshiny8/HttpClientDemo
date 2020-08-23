package com.course.testng.parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void test1(String name, int age) {
        System.out.println(name + "," + age);
    }
    @DataProvider(name="data")
    public Object[][] provider() {
        Object[][] o = new Object[][]{
                {"name1",1},
                {"name2",2},
                {"name3",3}
        };
        return o;
    }
    @Test(dataProvider = "singlePara")
    public void test2(String str) {
        System.out.println(str);
    }
    @DataProvider(name = "singlePara")
    public Object[][] provideSinglePara() {
        Object[][] o = new Object[][]{
                {"str1"},
                {"str2"},
                {"str3"}
        };
        return o;

    }

    //第二种传参方式
    @Test(dataProvider = "methodData")
    public void test11(int num) {
        System.out.println("one parameter:"+num);
    }
    @Test(dataProvider = "methodData")
    public void test12(int num1, int num2, int num3) {
        System.out.println("three parameters:"+num1+","+num2+","+num3);
    }
    @DataProvider(name = "methodData")
    public Object[][] providerMethodData(Method method) {
        Object[][] data = null;
        if (method.getName().equals("test11")) {
            data = new Object[][]{{1},{11},{111}};
        }else if(method.getName().equals("test12")) {
            data = new Object[][]{{1,2,3},{11,22,33}};
        }
        return data;
    }



}
