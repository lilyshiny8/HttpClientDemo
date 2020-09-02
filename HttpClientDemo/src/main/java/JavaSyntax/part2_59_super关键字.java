package JavaSyntax;
/*
1-
子类调用父类构造方法时使用super()
2-
在进行覆写的操作过程之中，子类也可以使用super.方法()  super.属性明确的调用父类中的方法和属性
规范上而言，调用父类的方法和属性一定要加super

StackOverFlowError 栈溢出异常

this---本类的访问处理操作---访问本类的属性和方法---查找的范围，先查找本类，如果本类没有再查找父类---特殊概念，this表示当前对象
super---子类访问父类的操作---由子类访问父类的属性和方法---查找的范围，直接查找父类---特殊概念，没有这个概念

1-子类覆写父类的方法是因为父类的功能不足才需要覆写
2-方法覆写的时候使用的就是public权限，将父类的方法名称直接粘贴过来最简单


 */
class Person59{
    private String name = "tony";
    public String sex = "male";
    int age = 18;
    public void printInfo(){
        System.out.println("父类的方法执行");
    }
}
class Student59 extends Person59{
    public void printInfo(){
        //调用父类的属性或者方法时一定要加super，一是明确指明调用父类的属性或者方法；而是便于差错
        //super.方法 表示由子类直接调用父类的方法
        super.printInfo();

        //调用父类的属性
        System.out.println("调用父类的public属性"+super.sex);
        System.out.println("调用父类的default属性"+super.age);


        System.out.println("子类的方法执行");
    }
}
public class part2_59_super关键字 {
    public static void main(String[] args) {
        Student59 stu = new Student59();
        stu.printInfo();

    }
}
