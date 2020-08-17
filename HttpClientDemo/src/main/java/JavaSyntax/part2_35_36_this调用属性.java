package JavaSyntax;

/*
1-调用本类属性---解决属性与参数重名的问题--this.属性---只要在类的方法中访问类的属性，属性前一定要追加this关键字
2-调用本类方法（构造，普通）
普通方法：this.方法名称(参数。。)
构造方法：this(参数。。)
构造方法和普通方法最大的区别：使用关键字new实例化类新对象的时候使用一次，普通方法是在实例化完成后（构造过了）可以调用多次
java里面支持类构造方法的互相调用
虽然使用this可以实现构造方法的相互调用，但是有以下两点要求：
1）this()调用构造方法的语句必须放在构造方法的首行；
2）使用this()调用构造方法的时候请留有出口
3-表示当前对象（相对概念）
在一个类之中肯定会产生若干个对象，那么程序类在分辨的时候不会记住有多少个对象产生了，只知道当前操作本类的对象是哪一个
 */
class Person_1 {
    private String name;
    private int age;
    public Person_1(){
        System.out.println("********generate a new object********");
    }
    public Person_1(String name) {
        //调用本类中的无参构造方法
        this();
        this.name = name;
    }
    public Person_1(String name, int age) {
        //调用本类中的有参构造方法
        this(name);
        //调用本类的属性
//        this.name = name;
        this.age = age;
        //虽然本类的普通方法前可以不使用this，但是强烈建议追加上this，这样可以区分方法的定义来源
        this.printCharacter();
    }
    public void printCharacter() {
        System.out.println("*************************");
    }
    public String getInfo(){
        return "name = " + this.name + ",age = " + this.age;

    }

}

public class part2_35_36_this调用属性 {
    public static void main(String[] args) {
        System.out.println(new Person_1().getInfo());
        System.out.println(new Person_1("name1").getInfo());
        System.out.println(new Person_1("name11",11).getInfo());
    }
}
