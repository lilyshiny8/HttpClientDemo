package JavaSyntax;

public class part2_4_类与对象定义 {
    /*
    声明并实例化对象
    类名称 对象名称 = new 类名称();
    分步进行对象实例化
    |-声明对象 类名称 对象名称 = null;
    |-实例化对象 对象名称 = new 类名称();

    new
    引用数据类型的最大特征在于对内存的分配操作，而只要出现有关键字new那就只有一个解释：开辟新内存。

    所有对象只有在实例化之后才可以使用，所有对象的使用都是围绕类进行的
    |-调用类中的属性   对象.属性 = 内容;
    |-调用类中的方法   对象.方法();


   */
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "a";
        person.age = 18;
        person.info();

        /*
        对象（所有的引用数据类型）必须在起开辟空间之后才可以使用。如果使用了未开辟空间的引用数据类型则将出现NullPointerException
        */
        Person per1 = null;//只声明对象，但并没有给他开辟内存空间，编译时不会产生语法错误，但是执行时会出现错误提示
        per1.info();
        //Exception in thread "main" java.lang.NullPointerException
        //	at Class_1_Object.main(Class_1_Object.java:28)
    }
}

/*
    class 类名称 {
            属性；
            方法() {}；
    }
*/
class Person {
    String name;
    int age;
    public void info() {
        System.out.println("name = "+name+", age = "+age);
    }
}
/*
引用类型指的是内存控件的操作。主要会使用两块内存空间：
|-堆内存空间：保存真正的数据；堆内存保存的是对象的属性信息；
|-栈内存空间：保存的堆内存的地址，堆内存操作权；简单理解保存的是对象名称；

 */


