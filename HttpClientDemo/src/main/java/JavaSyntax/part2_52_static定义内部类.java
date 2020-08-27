package JavaSyntax;

import com.google.gson.internal.bind.util.ISO8601Utils;

/*
内部类如果使用了static进行定义，那么就表示其是一个外部类的形式，但是这个外部类的名称就是 外部类.内部类
该内部类只允许方位外部类中的static
 */
class Outer1{
    private static String msg = "hello world";
    static class Inner1{
        public void print(){
            System.out.println(msg);
        }
    }
}
public class part2_52_static定义内部类 {
    public static void main(String[] args) {
        //外部类.内部类 内部类对象 = new 外部类.内部类()
        Outer1.Inner1 in1 = new Outer1.Inner1();
        in1.print();
    }
}
