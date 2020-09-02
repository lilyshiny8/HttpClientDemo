package JavaSyntax;
/*
子类定义了与父类相同的方法或者属性，这样的操作称为覆写
方法的覆写，子类定义了与父类方法名称、参数类型及个数完全相同的方法。但是被覆写的方法不能够用于比父类更为严格的访问控制权限

在以后进行覆写方法使用的时候一定要关注两点
1-你当前使用的对象是通过哪个类new的
2-当调用某一个方法，如果该方法已经被子类所覆写了，则调用的一定是被覆写的方法

 关于访问控制权限，才是封装的全部内容
 private(个人)<default（教师）<public（国家新闻）
 父类中的方法使用里public进行，那么子类中使用权限只能是public
 如果父类中的方法使用的是default权限，子类可以使用default或者public

 结论：
 以后写方法就写public，至少能保证你在99.99%是正确的
 同时定义属性时98%的情况下定义为private

 问题：如果父类中的方法用private定义，子类使用public覆写
 如果从概念上来讲，属于权限扩大，
 */
class Person57{
    public void printInfo(){
        System.out.println("父类的printInfo方法");
    }
}
class Student57 extends Person57{
    //99.99%情况下子类方法名称和父类中的方法名称是完全一样的
    public void printInfo(){
        System.out.println("子类的printInfor方法");
    }
}
public class part2_57_方法覆写 {
    public static void main(String[] args) {
        Student57 stu = new Student57();
        stu.printInfo();
    }


}
