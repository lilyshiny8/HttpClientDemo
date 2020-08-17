import java.net.StandardSocketOptions;

public class part2_8_构造方法与匿名对象 {
    /*
    类名称 对象名称 = new 类名称()
    new:开辟新的堆内存空间
    类名称():构造方法
    构造方法是使用关键字new实例化新对象时调用的方法。定义构造方法的原则：
    1-方法名称必须与类名称相同
    2-方法没有返回值
    3-类中至少有一个构造方法。如果类中没有明确的定义任何一个构造方法，那么将自动生成一个无参的什么都不做的构造方法

    类的组成：属性，普通方法，构造方法
    1-属性是在对象开辟堆内存的时候就开辟的空间
    2-构造方法是在使用关键字new同时调用的
        public Person8(); 从定义结构上区别于普通方法
    3-普通方法是在实例化之后再调用的（空间开辟了，调用方法执行了）
        public void Person8();  命名不标准


    构造方法的调用和对象内存分配几乎是同步完成的，可以利用构造方法设置类中的属性内容，构造方法可以为类中的属性进行初始化处理
    通过构造方法设置内容，可以避免重复的setter调用
    在实际开发中，setter除了有设置内容的功能之外，也可以承担修改数据的操作

    构造方法本身属于方法，那么方法就一定可以进行重载，而构造方法的重载更加简单。因为方法名称就是类名称，所以你能做就只是实现参数的类型和个数不同

     */

    public static void main(String[] args) {
        //2-类中定义一个有参构造方法
        Person8 p = new Person8("name1",12);
        p.setAge(120);
        p.info();
        //构造方法重载的应用
        Person8 p1 = new Person8("name11");
        p1.info();

        //匿名对象
        //由于匿名对象不会有任何的栈空间所指向，所以使用一次之后就会成为垃圾
        new Person8("niming").info();
    }
}
class Person8{
    private String name;
    private int age;
    //方法名称与类名称相同，并且没有返回值类型声明
//    //1-类中定义一个无参构造方法
//    public Person8() {//如果在类中不写此定义，也会在编译后自动生成
//        System.out.println("*********************");
//    }
    //2-类中定义一个有参构造方法
    public Person8(String n, int a) {
        setAge(a);
        setName(n);
    }
    //构造方法重载
    public Person8(String n) {
        setName(n);
    }
    public void setName(String n) {
        name = n;
    }
    public void setAge(int a) {
        age = a;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void info(){
        System.out.println("name = " + getName() + ", age = " + getAge());
    }

}