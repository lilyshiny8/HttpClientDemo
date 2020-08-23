package com.course.testng.parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class paramXML {
    @Test
    @Parameters({"name","age"})
    public void test1(String name, int age) {
        System.out.println("name="+name+",age="+age);

    }
}
