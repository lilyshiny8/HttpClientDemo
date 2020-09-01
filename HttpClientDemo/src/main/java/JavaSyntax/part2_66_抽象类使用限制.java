package JavaSyntax;
/*
1-抽象类只是比普通类多了抽象方法，抽象类之中依然允许提供构造方法，并且子类也会遵守子类对象的实例化流程。实例化子类对象前一定要先去调用父类的构造方法
抽象类中有构造方法很易理解，因为抽象类中有属性，所有的属性一定要在对象实例化的时候进行空间开辟，对象实例化必须要使用构造方法。

额外话题：关于对象实例化
对象的实例化操作实际上需要以下几个核心步骤
进行类的加载
进行类对象的空间开辟
进行类对象中的属性初始化（构造方法）


 */
//抽象类中定义构造
abstract class Person66{
    private String name;
    public Person66(){
        System.out.println("父类的无参构造方法");
    }
    public Person66(String name){//有参构造，相当于setter
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public abstract String getInfo();
}
class Student66 extends Person66{
    private String school;

    //如果父类中没有无参构造方法，那么子类就必须通过super()指明调用的是哪个父类构造
    public Student66(String name,String school){
        super(name);
//        System.out.println("子类的无参构造方法");
        System.out.println("用super()指定调用父类中的有参构造方法，子类的构造方法中传入参数");
        this.school = school;
    }
    public String getInfo(){
        System.out.println("子类覆写父类的抽象方法");
        return "name="+super.getName()+",school="+this.school;
    }
}
public class part2_66_抽象类使用限制 {
    public static void main(String[] args) {
        Person66 per = new Student66("tony","school");
        System.out.println(per.getInfo());

    }
}
