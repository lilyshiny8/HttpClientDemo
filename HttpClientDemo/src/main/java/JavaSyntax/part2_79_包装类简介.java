package JavaSyntax;
/*
基本数据类型和引用数据类型
包装类指的是将基本数据类型封装在一个类中。将基本数据类型包装为一个类对象的本质就在于方便的使用Object进行接收处理。
java中有八种基本数据类型
对于包装类提供有两种类型
1-对象型（Object直接子类）：Boolean Character（char）
2-数值型（Number直接子类）：Byte Double Short Long Integer（int） Float
关于Number类
1-
public abstract class Number
extends Object
implements Serializable
2-
Number类里面实际上定义有六个重要的方法：用于从包装类中取出数据值
intValue() shortValue() LongValue() byteValue() doubleValue() floatValue()
 */
public class part2_79_包装类简介 {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        a.intValue();
    }
}
