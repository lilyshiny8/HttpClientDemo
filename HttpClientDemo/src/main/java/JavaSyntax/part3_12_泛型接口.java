package JavaSyntax;
interface IMessage12<T>{
    public void print(T t);
}
/*
接口实现子类有两种方法
1-在子类定义的时候继续使用泛型
2-在子类实现接口的时候明确给出具体类型
 */
class MessageImpl11<T> implements IMessage12<T>{
    public void print(T t){//泛型方法。不过泛型方法不一定要定义在泛型类或者接口里面，也可以单独定义。6-
        System.out.println(t);
    }
}
class MessageImlp11_1 implements IMessage12<String>{
    public void print(String t){
        System.out.println(t);
    }
}
public class part3_12_泛型接口 {
    public static void main(String[] args) {
        IMessage12<String> mes = new MessageImpl11<String>();
        mes.print("子类实现的时候继续使用泛型");

        IMessage12<String> mes1 = new MessageImlp11_1();
        mes1.print("子类实现接口的时候明确定义具体的类型");
    }
}
