package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExpectionSuccess() {
        System.out.println("异常测试");
        throw new RuntimeException();
    }
}
