package JavaSyntax;
class Person18 {
    @Override//明确表示该方法是一个覆写的方法，如果覆写错误则会出现语法错误
    public String toString(){
        return "override toString method";
    }
    @Deprecated//表示该方法已经不建议使用了，但是即使使用了也不会出现错误
    public Person18(){};
    public Person18(String name){};
    @Deprecated
    public void fun(){
        System.out.println("fun");
    };

}

public class part3_18_annotation {
    public static void main(String[] args) {
        //调用deprecated的构造函数，和方法
        Person18 p = new Person18();
        Person18 p1 = new Person18("A");
        p.fun();
        p1.fun();

        @SuppressWarnings("unused")//压制警告
        Person18 p2 = new Person18();

    }




}
