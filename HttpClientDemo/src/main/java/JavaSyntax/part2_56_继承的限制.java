package JavaSyntax;
/*
继承的限制
1-
子类对象的进行实例化前一定会首先实例化父类对象，默认调用父类的构造方法后再调用子类的构造方法进行子类对象的实例化
需要注意的是，当父类中存在无参的构造方法时，子类的构造方法中相当于隐含了一个语句 super()
当父类中不存在无参的构造方法，子类的构造方法中必须使用super()指明要调用父类的哪个构造函数
2-
java中只允许单继承，不允许多继承
一个子类只能够继承一个父类
错误范例：
class A{}
class B{}
class C extends A,B{}
为了实现C可以继承A和B的操作，可以采用多层继承的形式完成
class A{}
class B extends class A{}
class C extends class B{}
一般最多三层结构，不建议再多
总结：java不允许多重继承，但允许多层继承

3-
子类会继承父类的所有结构。包括私有属性，构造方法，普通方法
需要注意的是，所有的非private属于显式继承（可以直接调用），而所有的private属于隐式继承（通过其他形式调用，例如setter getter）
父类中的属性全部被子类继承，但是发现子类能够使用的只是所有非private操作，而所有的private操作肯定无法直接使用，所以称为隐式继承



 */
public class part2_56_继承的限制 {
    public static void main(String[] args) {
        Student56 stu = new Student56("tony","aa");


    }
}
class Person56{
    private String str = "private";
    public Person56(){}
    public Person56(String name) {
        System.out.println("父类构造方法执行");
    }
}
class Student56 extends Person56{

    public Student56(String name, String school){
        //既然要进行构造方法的调用，构造方法的调用一定要放在构造方法的首行
        //如果父类中有提供无参构造，加或者不加super()均可以
        //如果父类中没有提供无参构造，这个时候就必须用super()明确指明你要调用的父类构造方法
        //super(); //指定调用父类的无参构造方法
        super(name); //指定调用父类的有参构造方法
        System.out.println("子类构造方法执行");

    }

}
