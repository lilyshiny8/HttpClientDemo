package JavaSyntax;

import org.testng.annotations.Test;

/**fdfshfjdfljgfkghdf */
/*
fdgfdgdf
 */
public class other_Recursion {
    @Test
    public void test1() {
        System.out.println("Factorial of 5 is: "+factorial(5));
    }
    static int factorial(int n){
        if (n == 1)
            return 1;
        else
            System.out.println(factorial(n-1));
            return(n * factorial(n-1));
    }


}
