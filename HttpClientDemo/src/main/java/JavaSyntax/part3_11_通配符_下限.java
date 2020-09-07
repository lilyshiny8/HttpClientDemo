package JavaSyntax;
/*
？表示能接收一切，但不能修改

? extends 类：设置泛型上限----
    |- ? extends Number 表示只能设置Number或其子类
? super 类：设置泛型下限----只能在参数上
    |- ? super String 表示只能设置String或其父类
 */
class Person11_1<T>{
    private T a;
    public T getA() {
        return a;
    }
    public void setA(T a) {
        this.a = a;
    }
}

public class part3_11_通配符_下限 {
    public static void main(String[] args) {
        //Number
        Person11_1<Number> p = new Person11_1<Number>();
        p.setA(1);
        fun(p);
        //Number的父类Object
        Person11_1<Object> p1 = new Person11_1<Object>();
        p1.setA(1.1);
        fun(p1);
    }

    public static void fun(Person11_1<? super Number> p){//下限
        System.out.println(p.getA());
    }
}
