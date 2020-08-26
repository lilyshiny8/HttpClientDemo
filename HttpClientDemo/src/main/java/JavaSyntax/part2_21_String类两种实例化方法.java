package JavaSyntax;

public class part2_21_String类两种实例化方法 {
    public static void main(String[] args) {

        //通过关键字new进行对象实例化，"AAA"在堆内存中
        //方式1，所以String类的构造方法 public String(String str);
        String name = new String("AAA");
        //方式2
        String name1 = "BBB";

    }
}
