package JavaSyntax;
/*
1-接口里面只允许由public权限，也就说不管是属性还是方法，都是public
核心总结只要是方法就使用public定义
由于接口只是全局常量和抽象方法的集合，所以以下三种的定义形式最终效果都是一样的
99%的接口里只会提供有抽象方法，很少会在接口中看到有许多全局常量
2-
当一个子类即需要继承接口，又需要继承抽象类的时候，请先使用extends继承“一个”抽象类，而后再使用implements实现“多个”接口。
3-
一个类可以使用implements实现多个接口，但是接口不能够去继承抽象类
抽象类implements接口
4-
一个接口可以使用extends来继承多个父接口
interface A {
    public void printA();
}
interface B {
    public void printB();
}
interface C extends A,B{
    public void printC();
}
class Impl implements C{
    public void printC() {};
    public void printA() {};
    public void printB() {};
}
5-
接口可以定义一系列的内部接口，包括，内部的普通类，内部抽象类，内部接口。其中使用static定义的内部接口就相当于是一个外部接口
interface A {
    static interface B{//使用了static定义，描述一个外部接口
        public void printB();
    }
}
class X implements A.B{//实现内部接口
    public void printB(){};
}
 */

interface Inews {
    //1-
//    public static String meg = "standard format";
//    public abstract String get();
    //2-
//    public static String meg = "simple format";
//    public String get();
    //3-
    String meg = "simple format";
    public String get();

}
abstract class AbstractMessage{
    public abstract void print();
}
//类继承接口和抽象类
class News extends AbstractMessage implements Inews{
    public void print(){
        System.out.println("overridden the abstract method:print");
    }
    public String get(){
        return "overridden the implement's abstract method:get";
    }
}
public class part2_69_接口使用限制 {
    public static void main(String[] args) {
        //News是抽象类和接口的共同子类
        Inews news = new News();
        System.out.println(news.get());
        AbstractMessage meg = (AbstractMessage) news;
        meg.print();


    }
}
