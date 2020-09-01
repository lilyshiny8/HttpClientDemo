package JavaSyntax;
/*
对象多态性的核心本质在于方法的覆写，如果说子类没有进行指定方法的覆写，这样的操作就有些不合要求的。
所以如果要对子类的方法进行一些强制的要求，就必须采用抽象类

抽象类只是在普通类的基础上扩充了一些抽象方法而已。抽象方法指的是只声明而未实现（没有方法体）。
所有的冲向方法要求使用abstract关键字来进行定义，并且抽象方法所在的类，也要求使用abstract来表示抽象类

对于抽象类的使用原则：
-所有的抽象类必须要有子类
-抽象类的子类（不是抽象类）必须覆写抽象类中的所有抽象方法
    -方法覆写一定要考虑权限问题：抽象方法可以使用任意权限，要求权限尽量都用public
-抽象类的对象可以通过对象多态性，利用子类为其实例化
 */
//抽象类就是比普通类多了一些抽象方法而已
abstract class A65{
    private String msg = "abstract";
    public void print() {
        System.out.println(msg);
    }
    //{}为方法体，所有抽象方法上是不包含有方法体的
    public abstract void fun();//抽象方法
    //private 和 abstract 方法修饰符不能一起使用
//    private abstract void fun();//illegal combination modifiers: abstract and private
}
class B65 extends A65{
    public void fun(){
        System.out.println("子类覆写父类中的抽象方法fun()");
    }
}
public class part2_65_抽象类基本定义 {
    public static void main(String[] args) {
        //向上转型
        A65 a = new B65();
        //根据new B65()找到子类中的fun()方法.被子类覆写过的方法
        a.fun();
    }
}
