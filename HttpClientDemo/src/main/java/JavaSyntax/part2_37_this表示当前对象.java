package JavaSyntax;

/*
3-表示当前对象（相对概念）
在一个类之中肯定会产生若干个对象，那么程序类在分辨的时候不会记住有多少个对象产生了，只知道当前操作本类的对象是哪一个
 */
class Person_2{
    public void fun() {
        System.out.println("[fun]"+this);
    }
}

public class part2_37_this表示当前对象 {
    public static void main(String[] args) {
        Person_2 per1 = new Person_2();
        System.out.println("[main]" + per1);
        per1.fun();
        Person_2 per2 = new Person_2();
        System.out.println("[main]" + per2);
        per2.fun();
    }

}
