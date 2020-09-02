package JavaSyntax;
/*
装箱：将基本数据类型变为包装类对象
    利用每一个包装类提供的构造方法实现装箱处理
拆箱：将包装类中包装的基本数据类型取出
    可以Number中提供的xxValue()

选择：使用int还是Integer？
在接收数据的时候，使用的一定都是int，而保存数据的时候会使用Integer
以后编写的简单java类统一不要再去使用基本数据类型，全部更换为包装类
 */

public class part2_80_装箱与拆箱 {
    public static void main(String[] args) {
        //手工的装箱和拆箱处理操作形式
        Integer it = new Integer(10);//装箱
        int x = it.intValue();//拆箱

        //自动装箱和拆箱
        Integer num = 10;//自动装箱
        //可以直接利用包装类对象操作
        System.out.println(num * 2);

        //这个时候仍然存在有”==“和equals()问题
        Integer num1 = 10;
        System.out.println(num == num1);
        System.out.println(num == new Integer(10));//false
        System.out.println(num.equals(num1));

        //int和integer的区别
        int a = 0;
        Integer b = null;


    }
}
