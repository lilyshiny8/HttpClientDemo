package JavaSyntax;
/*
理论上内部类可以定义在类中的任何位置：类中，方法中，代码块中
方法中定义内部类使用最多
 */
class Outer2{
    private String msg = "hello world";
    public void fun(int num) {
        class Inner2{
            public void print() {
                System.out.println("num="+num);
                System.out.println("msg="+msg);
            }
        }
        new Inner2().print();//产生内部类的对象并且调用方法
    }
}
public class part2_57_在方法中定义内部类 {
    public static void main(String[] args) {
        new Outer2().fun(100);
    }
}
