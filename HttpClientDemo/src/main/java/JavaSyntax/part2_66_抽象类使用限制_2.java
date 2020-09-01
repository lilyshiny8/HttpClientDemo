package JavaSyntax;
/*
2-抽象类中允许不定义任何的抽象方法，但是此时抽象类对象依然无法进行直接实例化处理
3-抽象类一定不能够使用final进行声明，因为使用final定义的类不能够有子类，而抽象类必须有子类；
    -抽象方法不能使用private进行定义，因为抽象方法必须被覆写
4-抽象类也分为内部抽象类和外部抽象类。内部抽象类也可以用static定义，描述为外部抽象类
 */

//对应2
abstract class A66_1{
    public A66_1(){
    }
}
//对应4，内部抽象类
abstract class AA {
    public abstract void printAA();
    abstract class BB {
        public abstract void printBB();
    }
}
class X extends AA{
    public void printAA(){}//只要求覆写AA的抽象方法，不要求覆写BB的抽象方法
    class Y extends BB{
        public void printBB(){};
    }
}


//对应4，内部抽象类也可以用static定义，描述为外部抽象类
abstract class AAA{
    public abstract void printAAA();
    static abstract class BBB{
        public abstract void printBBB();
    }
}
class XX extends AAA.BBB{
    public void printBBB(){};
}


public class part2_66_抽象类使用限制_2 {
    public static void main(String[] args) {
        //对应2，抽象类中允许不定义任何的抽象方法，但是此时抽象类对象依然无法进行直接实例化处理
//        A66_1 a = new A66_1();

    }
}
