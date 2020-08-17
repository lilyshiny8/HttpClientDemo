package JavaSyntax;

/*
请解释String类中两种对象的实例化方式的区别
直接赋值：直接赋值只会开辟一块堆内存空间，并且该字符串对象可以保存在对象池中以供下次使用
构造方法：使用构造方法会开辟两块堆内存空间，一块成为垃圾并且不会自动保存在对象池之后，可以使用intern()方法手工入池

实际编程中使用直接赋值即可
 */
public class part2_24_String两种实例化区别 {
    public static void main(String[] args) {
        //intern() 将字符串常量手工入对象池（对象数组）
        String str1 = new String("hello").intern();
        String str2 = "hello";
        System.out.println(str1 == str2);
    }
}
