package JavaSyntax;
/*
多态的核心表现主要有以下两点，
1-方法的多态性
-方法的重载，同一个方法名称可以根据参数的类型及个数的不同调用不同的方法体
-方法的覆写，同一个父类的方法，可能根据实例化的子类不同也有不同的方法
2-对象的多态性（前提是方法覆写）
-对象的向上转型：父类 父类对象 = 子类实例        【下到上的转换是自动的】
-对象的向下转型：子类 子类对象 = (子类)父类实例   【上到下的转换是强制的】
eg. int + long = long

//总结
        //对象多态性实现的核心在于方法的覆写
        //通过对象的向上转型可以实现接收参数的统一，而向下转型可以实现子类扩充方法的调用（一般不操作向下转型）
        //两个没有关系的类对象是不能够进行转型的，一定会发生ClassCastException，所以向下转型是存在有安全隐患的。
 */

class A{
    public void print(){
        System.out.println("AAAAAAAAAAA");
    }
}
class B extends A{
    public void print(){
        System.out.println("BBBBBBBBBBB");
    }
    public void funB(){//这个方法只有子类有
        System.out.println("B's function");
    }
}
public class part2_64_多态 {
    public static void main(String[] args) {
        //向上转型
        //不管是否发生了向上转型，其核心的还在于new的是是谁，且调用的方法是否被子类所覆写了。
        A a = new B();
        a.print();


        //向下转型指的是将父类对象变为子类对象，但是在这之前需要首先明确一个核心概念，为什么需要向下转型？当你需要使用到子类扩充操作时就需要向下转型
        B b = (B) a;//向下转型
        b.funB();

        //但是并不是所有的父类对象都可以向下转型：如果要进行向下转型操作之前一定要首先向上转型，否则在转型时会出现ClassCastException
        //**********************错误的转型**************************************
        //父类不知道有哪些子类继承了他
//        A a_error = new A();
//        B b_error = (B) a_error;
//        b_error.funB();//error:Exception in thread "main" java.lang.ClassCastException: JavaSyntax.A cannot be cast to JavaSyntax.B

        //如果向下转型可能存在有隐患，那么如何转型才靠谱？最好的做法是先进行判断，而后进行转型。使用instanceof关键字来实现。避免ClassCastException的问题
        A a1 = new B();
        System.out.println(a1 instanceof A);
        System.out.println(a1 instanceof B);





    }
}
