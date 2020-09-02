package JavaSyntax;

/*
99%的情况下是不会定义static属性的
如果想要描述共享属性，或者想通过类名直接调用属性时，才考虑

constraint
所有static方法不允许调用非static定义的属性或方法
所有非static方法允许访问static属性和方法

static方法
可以通过类名直接调用方法时使用

 */
class Person_44{
    private String name;
    private int age;
    static String country = "China";//减少内存占用

    public Person_44(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    //静态方法
    public static void setCountry(String c) {
        country = c;

    }
    public void getInfo() {
        //非static方法访问static方法
        setCountry("Japan");
        System.out.println("name=" + this.name + ", age=" + this.age + ", country=" + country);
    }
}

public class part2_44_static属性_45_static方法 {
    public static void main(String[] args) {
        Person_44 p1 = new Person_44("name1",1);
        Person_44 p2 = new Person_44("name2",2);
        Person_44.country = "china1";//静态属性可以通过类名称直接调用//共享属性//不在堆内存中，会保存在全局数据区中
        p1.setName("anonymity");//传统属性所具备的特征就是保存在堆内存之中，并且每一个对象独享此属性
        p1.getInfo();
        p2.getInfo();

        //static方法
        Person_44.setCountry("American");
        p1.getInfo();
        fun();
    }
    public static  void fun(){

    }

}
