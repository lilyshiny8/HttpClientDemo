package JavaSyntax;

/*
底层是字符数组，数组的缺陷是长度固定
开发原则
1.字符串的使用就采用直接赋值的模式完成
2.字符串的比较就采用equals()
3.字符串没事别改变太多，会造成堆内存浪费

 */
public class part2_25_字符串常量不可变更 {
    public static void main(String[] args) {
        String str = "hello";
        str = str + " world";
        str += "!!!";
        System.out.println(str);
        //此过程中，字符串常量"hello" "world" "hello world" "!!!" 开辟的内存空间均成为垃圾

    }
}
