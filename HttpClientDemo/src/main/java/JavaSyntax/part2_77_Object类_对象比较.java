package JavaSyntax;
//public boolean equals(Object obj)

class Person_77 extends Object {
    private String name;
    private int age;
    public Person_77(String name,int age) {
        this.name = name;
        this.age = age;
    }
    //覆写equals方法
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        //this代表当前对象per1
        if(this == obj){
            System.out.println("this,"+this);
            System.out.println("obj,"+obj);
            return true;
        }
        //ClassCastException
        if (!(obj instanceof Person_77)) {
            return false;
        }
        //必须将Object类型变为Person类型后才可以调用name和age属性
        Person_77 per = (Person_77) obj;
        return this.name.equals(per.name) && this.age == per.age;
    }
    //默认情况下Object类中提供的toString()方法只能够得到一个对象的地址（而这是所有对象都共同具体的特征）
    //如果认为功能不足，在需要的子类上复写toString()方法
    //覆写toString方法
    public String toString() {
        return "name = " + this.name + ", age = " + this.age;
    }

}

public class part2_77_Object类_对象比较 {
    public static void main(String[] args) {
        Person_77 per1 = new Person_77("name",1);
        Person_77 per2 = new Person_77("name",2);
        System.out.println(per1.equals(per2));
//        System.out.println(per1.toString());

//        System.out.println(per1.equals("hello"));//ClassCastException
    }
}
