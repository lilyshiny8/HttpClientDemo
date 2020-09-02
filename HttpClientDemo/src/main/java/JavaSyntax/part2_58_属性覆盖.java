package JavaSyntax;
/*
子类中的属性名称与父类中的相同，不要求类型也相同
 */
class Person58{
    public String info = "this is farther's attribute";
}
class Student58 extends Person58{
    public int info = 10;
    public void fun(){
        System.out.println(info);
    }
}
public class part2_58_属性覆盖 {
    public static void main(String[] args) {
        Student58 stu = new Student58();
        stu.fun();
    }
}
//属性的覆写本身是没有意义的，因为所有类中属性都要求private封装。一旦封装，子类不知道父类中有哪些属性
//结论：在定义属性的时候没事干别整重名
