package JavaSyntax;
/*
要进行各种数据的输入一定都是字符串类型的接收，如何将字符串变为各个基本数据类型
 */
public class part2_81_字符串与基本数据类型转换 {
    public static void main(String[] args) {
        //****将字符串变为基本数据类型****
        //public static int parseInt(String s)
//        int x = Integer.parseInt("a");//java.lang.NumberFormatException
        int x = Integer.parseInt("1");
        System.out.println(x);

        //public static double parseDouble(String s)

        //public static boolean parseBoolean(String s)
        //原则非常明确，true。否则全部输出false


        //****将基本数据类型变为字符串****
        //任何的数据类型使用了”+“连接空字符串就变成了字符串类型
        System.out.println((1 + "").getClass());
        //使用String类中提供的一个valueOf方法，而且valueOf方法被重载了很多次
        //public static String valueOf(char[] data)
       String str = String.valueOf(new char[]{'a','b','c'});
        System.out.println(str);
    }
}
