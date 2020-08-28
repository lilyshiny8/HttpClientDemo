package JavaSyntax;
/*
 问题：如果父类中的方法用private定义，子类使用public覆写
 如果从概念上来讲，属于权限扩大，但其实是不正确的

 重载overloading---方法名称相同，参数类型及个数不同---发生在一个类之中---无限制
 覆写overridden---方法名称及参数类型及个数均相同--继承关系之中---子类不能拥有比父类更为严格的访问权限限制
 */
class Person57_1{
    public void fun(){
        this.printInfo();
    }
    //该方法只能被父类使用，子类不知道父类有这样的方法
    //这时候子类中的方法只是定义的新方法而已
    private void printInfo(){
        System.out.println("父类的printInfo方法");
    }
}

class Student57_1 extends Person57_1{
    //
    public void printInfo(){
        System.out.println("子类的printInfor方法");
    }
}

public class part2_57_方法覆写_1 {
    public static void main(String[] args) {
        Student57_1 stu = new Student57_1();
        //这里调用的fun
        stu.fun();
    }


}
