package JavaSyntax;

public class part1_10_TypeInteger {
    public static void main(String[] args) {
        //在java程序里面任何一个整数的常量类型都是int
        int num = 10;
        System.out.println( num * 2);
        //数据溢出
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        System.out.println(maxValue + 1);//-2147483648//汇编 2的n次方 第一位是符号位
        System.out.println(minValue -1);//2147483646
        //产生数据溢出后更换更大的数据类型long
        //所有程序执行的顺序都是由等号的右边到左边.将其中一个变量做类型的扩充。两种方式：
        //1-直接将int变量的内容赋值给long变量
        long result = maxValue;
        //result是long类型 + 1是int类型 = long类型 （大类型+小类型=大类型）
        System.out.println(result + 1);
        //2-直接将int型变量变为long型
        long result1 = (long) maxValue+1;
        System.out.println(result1);

        //将大类型变成小类型。需要强制完成，会丢失内容
        long num1 = 2147483648L;//'L''l'均可
//        long num1_1 = (long) 2147483648; // 这样写报错
        //在强制的时候设置其目标类型
        int num2 = (int)num1;//这种操作有可能会丢失精度
        System.out.println(num2);//-2147483648


        //所有数据类型都有其默认值，但是这个默认值在方法的声明中（主方法）无效
        //错误示例
//        int num3;
//        System.out.println(num3);
        //两种解决方法
        //1-在使用前为变量赋值；
        int num3;
        num3 = 10;
        //2-以上方式在老版本的JDK中也会出错，所以最保险的方法在变量声明的时候设置默认值
        int num4 = 10;

        //说到整型数据就不得不说到byte类型-----byte在二进制流或者编码转换时用
        //1- 10是int类型，num5是byte；int大于byte类型，理论上要进行强制转换，但是其数据量符合byte的要求，故不用强制转
        byte num5 = 10;
        //2- 如果为byte赋值的内容大于byte的范围，这时候就需要强制转换了
        byte num6 = (byte) 128;
        //3-
        int num7 = 10;
        byte num8 = (byte) num7; // byte num8 = num7; 大类型转为小类型





    }
}
