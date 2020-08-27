package JavaSyntax;
/*
一个类的内部进行其他 类结构嵌套的操作语法形式
1-破坏了程序的结构
2-方便的进行私有属性的访问，在外部类或者内部类中定义private属性，外部类或内部类的方法均可以访问
3-如果发现类名称上出现了”.“应该立马想到内部类的概念
如果一个内部类执行被外部类使用，即不希望直接产生内部类的实例化对象，那么可以使用private定义。在class Inner前加private（加了private只能被Outer内部调用）

 */
class Outer {
    private String msg = "hello world!";
    //内部类
    class Inner {
        public void print(){
            //msg是Outer的属性
            System.out.println(msg);
            //外部类.this.属性   外部类当前对象的属性
            System.out.println(Outer.this.msg);
        }
    }
    //外部类中定义一个方法，这个方法负责产生内部类对象，并调用print方法
    public void fun() {
        Inner in = new Inner();//内部类对象
        in.print();//内部类方法
    }


}

public class part2_51_内部类的定义及使用 {
    public static void main(String[] args) {
        //1-
        //通过外部类方位内部类的方法
        Outer ot = new Outer();
        ot.fun();

        //2-如果不想通过外部类的方法才能访问内部类，换种方法
        //外部类.内部类 内部类对象名称 = new 外部类().new 内部类()
        //外部类.内部类，为什么用.  看class文件的名称：Outer$Inner.class   $在程序中就代表.
        //new 外部类().new 内部类()  第一个new是因为Outer中有属性msg，必须生成实例才能访问，第二个new实例化后访问print
        Outer.Inner in1 = new Outer().new Inner();
        in1.print();
    }
}
