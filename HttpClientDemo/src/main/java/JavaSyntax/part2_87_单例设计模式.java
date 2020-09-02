package JavaSyntax;

import javax.xml.bind.annotation.XmlAnyAttribute;

/*
一个类只允许产生一个实例化对象
singleton
 */
class SingletonTest{
    private static SingletonTest instance = new SingletonTest();//内部产生实例化对象//在类的内部是允许访问私有的结构的，所以在内部产生实例化对象
    public static SingletonTest getInstance(){
        return instance;
    }
    private SingletonTest(){};//一旦构造函数被私有化了，那么就表示外部无法调用构造了，外部不能够产生新的实例化对象。此时的类是一个相对而言封闭的状态
    public void print(){
        System.out.println("hello world");
    }
}
public class part2_87_单例设计模式 {
    public static void main(String[] args) {
        SingletonTest s =null;
        s = SingletonTest.getInstance();
        s.print();
    }
}
