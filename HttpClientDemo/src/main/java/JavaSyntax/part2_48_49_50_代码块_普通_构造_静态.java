package JavaSyntax;
/*
代码块指的是用{}括住的一段代码-------都没什么用
普通代码块：定义在方法中的代码块 。方法中写的代码过长，避免变量重名，使用该方法
构造块:定义在类中的代码块，有了构造块之后会发现，构造块会优先于构造方法执行.可以有多个构造块
静态代码块：使用了static关键字定义的代码块，分为两种情况：
在非主类中定义---静态块优先于构造块执行，不管产生多少个实例化对象，静态块也只用一次。主要作用是对static做初始化处理
在主类中定义---静态块将优先于主方法执行


优先顺序
静态块  构造块  构造方法
 */
public class part2_48_49_50_代码块_普通_构造_静态 {
    public static void main(String[] args) {
        //定义在main方法中，用大括号围起来
        {
            int x = 10;
            System.out.println("x="+x);
        }

        int x = 100;
        System.out.println("x="+x);

        //Person48匿名实例
        new Person48();
        new Person48();
    }
    //在主类中定义，优先于主方法执行
    static{
        System.out.println("*****************************");
    }
}
class Person48{
    private static String info = "hello";
    //构造块
    {
        System.out.println("1，构造块");
    }
    public Person48(){
        System.out.println("2，构造方法");
    }
    //多个构造块
    {
        System.out.println("3，构造块");
    }
    //静态块
    static{
        System.out.println("4，静态块");
        info = info+" world";//对static进行初始化配置
        System.out.println("info="+info);
    }
}
