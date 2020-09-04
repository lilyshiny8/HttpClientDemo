package JavaSyntax;


/*
1-工厂设计模式
java实现可移植性的关键是JVM，也就说所有的程序是在JVM上执行，而不同的操作系统中有匹配的JVM
程序 -> JVM -> 操作系统
这个时候new是整个开发过程之后最大的耦合元凶，而我们在开发之后要进行解耦合的关键就在于引入一个第三方，所以这个类可以使用Factory来描述
总结：如果想要取得接口的实例化对象，第一反应写工厂类
2-代理设计模式
3-单例设计模式
 */
interface IFruit {
    public void eat();
}
class Factory {
    //static 因为此时Factory产生实例化对象没有意义
    public static IFruit getInstance(String className) {
        if("apple".equals(className)){
            return new Apple();
        }
        if("orange".equals(className)){
            return new Orange();
        }
        return null;
    }
}
class Apple implements IFruit{
    public void eat(){
        System.out.println("eat apple");
    }
}
class Orange implements IFruit{
    public void eat(){
        System.out.println("eat orange");
    }
}
public class part2_71_工厂设计模式 {
    public static void main(String[] args) {
        //子类为接口进行对象的实例化处理
//        IFruit fruit = new Apple();
//        fruit.eat();

        if(args.length != 1) {//没有传递一个参数
            System.out.println("程序执行错误，正确的格式：java TestDemo 类名称");
            System.exit(1);
        }
        IFruit fruit = Factory.getInstance(args[0]);
        fruit.eat();

    }
}
