package JavaSyntax;
/*
？表示能接收一切，但不能修改

? extends 类：设置泛型上限----
    |- ? extends Number 表示只能设置Number或其子类
? super 类：设置泛型下限----只能在参数上
    |- ? super String 表示只能设置String或其父类
 */
class Person11<T extends Number>{//上限
    private T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Person11{" +
                "a=" + a +
                '}';
    }
}
public class part3_11_通配符 {
    public static void main(String[] args) {
        //Number
        Person11<Number> p = new Person11<Number>();
        p.setA(1);
        System.out.println(p.getA());
        fun(p);
        //Number的子类Integer
        Person11<Integer> p1 = new Person11<Integer>();
        p1.setA(1);
        p1.getA();
    }

    public static void fun(Person11<? extends Number> p){//上限
        System.out.println(p.getA());
    }
}
