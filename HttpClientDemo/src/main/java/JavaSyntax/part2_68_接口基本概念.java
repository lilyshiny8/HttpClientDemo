package JavaSyntax;
/*
抽象类与普通类相比最大特点是约定了子类的实现要求，但是抽象类有一个缺点：单继承局限。
开发设计原则：接口优先
接口：是抽象方法和全局常量的集合。在java中接口可以使用interface关键字来进行定义
 */
//为了区分接口，在所有接口前面加I
interface IMessage {
    public static final String MSG = "interface";//常量
    public abstract void print();//抽象方法
}
interface INews {
    public abstract String get();
}
//一个类现在可以同时实现多个接口
class MessageImpl implements IMessage,INews{

    public void print(){
        System.out.println("print method:"+IMessage.MSG);
    };
    public String get(){
        return IMessage.MSG;//访问常量都建议加上类名称
    };
}
//一个类只实现了一个接口
class NewsImpl implements INews{
    public String get(){
        return "NewsImpl onlys inherit INews interface";
    }
}
public class part2_68_接口基本概念 {
    public static void main(String[] args) {
//        INews m = new MessageImpl();//子类为父接口实例化
//        m.print();//被子类覆写过的抽象方法

        //n表示的并不是INews，而是MessageImpl-----名称不重要，重点看new的是哪个类---------
        //MessageImpl是IMessage的子类
        INews n = new MessageImpl();
        IMessage ms = (IMessage) n;
        ms.print();

        //NewsImpl没有继承IMessage接口，进行转换时报异常ClassCastException
        INews news = new NewsImpl();
        IMessage message = (IMessage) news;
        message.print();
        //当一个子类继承了多个接口之后，接口对象通过子类进行实例化，多个父接口之间是允许互相转换的。但是转换的前提条件是依附于子类的
        // （通过MessageImpl实例化后可以互相转换  INews n = new MessageImpl();）

    }
}
