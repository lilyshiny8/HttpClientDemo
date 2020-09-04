package JavaSyntax;
/*
基本上匿名内部类都是在接口或抽象类的基础上完成的
 */
interface IMessage74{
    public void print();
}
//class MessageImpl74 implements IMessage74{
//    public void print() {
//        System.out.println("hello world");
//    }
//}
public class part2_74_匿名内部类 {
    public static void main(String[] args) {
//    IMessage74 message = new MessageImpl74();
        //如果IMessage74只使用一次，没有必要定义为单独的类。
        // 改为由匿名内部类实现
        //接口IMessage74不能直接实例化，加{}
    IMessage74 message = new IMessage74() {
        public void print() {
            System.out.println("hello world");
        }
    };

    fun(message);
    }

    public static void fun(IMessage74 message) {
        message.print();
    }
}
