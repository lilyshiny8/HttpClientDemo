package JavaSyntax;

/*
Object是java的基类
Object类是参数的最高统一类型
Object类本身也具备有一些定义的方法
1-构造，无参构造是专门为子类提供服务的
Constructors
public Object()
2-
public String toString()


在使用对象直接输出的时候发现默认情况下输出的是对象的地址，而用String类输出的时候是内容，主要原因是toString()方法的原因
toString()的核心目的在于取得对象信息，相当于取代了简单java类中的getInfo()方法的功能


 */
class Person_76 extends Object {
    private String name;
    private int age;
    public Person_76(String name,int age) {
        this.name = name;
        this.age = age;
    }
    //默认情况下Object类中提供的toString()方法只能够得到一个对象的地址（而这是所有对象都共同具体的特征）
    //如果认为功能不足，在需要的子类上复写toString()方法
    //覆写toString方法
    public String toString() {
        return "name = " + this.name + ", age = " + this.age;
    }

}

public class part2_76_Object类 {
    public static void main(String[] args) {
//        public String toString()
        fun("hello");

        fun(new Person_76("name1",11));

        //String是作为信息输出的重要数据类型，Java中所有的数据类型只要遇到了String，并且执行了"+"连接操作，
        //都要求将其变成字符串后连接，而所有对象要想变为字符串就默认使用toString()方法
        String result = "hello" +","+ new Person_76("name2",2);
        System.out.println(result);
    }
    public static void fun (Object obj) {
        System.out.println(obj.toString());//默认输出对象调用的就是toString方法，所以obj 和 obj.toString 的输出效果都是相同的//对toString方法进行覆写
    }
}
