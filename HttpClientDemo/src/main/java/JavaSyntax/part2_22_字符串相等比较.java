package JavaSyntax;

public class part2_22_字符串相等比较 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1);
        System.out.println(str2);
        //比较的是对象地址
        System.out.println(str1 == str2);
        //String中==和equals()的区别
        //==比较的是两个字符串对象的内存地址数值
        //equals() 可以进行字符串内容的比较
        System.out.println(str1.equals(str2));

    }
}
