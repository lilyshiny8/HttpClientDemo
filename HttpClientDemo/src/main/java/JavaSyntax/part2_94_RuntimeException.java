package JavaSyntax;
/*
public static int parseInt(String s) throws NumberFormatException
这个方法上已经明确的抛出了一个异常，但是在进行调用的时候即使没有异常处理也可以正常执行，这个就属于RuntimeException的范畴
观察NumberFormatException的结构
Class NumberFormatException
java.lang.Object
java.lang.Throwable
java.lang.Exception
java.lang.RuntimeException
java.lang.IllegalArgumentException
java.lang.NumberFormatException

如果所有可能产生异常的地方都要求进行强制性的异常处理，代码就太复杂了。所以在异常设计的时候考虑到一些异常可能是简单的问题，所以将这一类的异常统一称为RuntimeException
使用RuntimeException定义的异常类可以不需要强制性进行异常处理

Exception和RuntimeException的区别
Exception是RuntimeException的父类，使用Exception定义的异常都要求必须使用异常处理
RuntimeException可以由用户选择性的来进行异常处理
常见的RuntimeException
    ClassCastException
    NullPointerException
 */

public class part2_94_RuntimeException {
    public static void main(String[] args) {

        int num = Integer.parseInt("100");
        System.out.println(num);
        //断言
        assert num == 101: "num不等于101";
    }
}
