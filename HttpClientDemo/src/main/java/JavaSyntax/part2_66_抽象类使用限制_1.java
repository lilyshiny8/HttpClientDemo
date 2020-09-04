package JavaSyntax;
/*
1-抽象类只是比普通类多了抽象方法，抽象类之中依然允许提供构造方法，并且子类也会遵守子类对象的实例化流程。实例化子类对象前一定要先去调用父类的构造方法
抽象类中有构造方法很易理解，因为抽象类中有属性，所有的属性一定要在对象实例化的时候进行空间开辟，对象实例化必须要使用构造方法。

额外话题：关于对象实例化
对象的实例化操作实际上需要以下几个核心步骤
进行类的加载
进行类对象的空间开辟
进行类对象中的属性初始化（构造方法）

结论：
如果构造方法没有执行，那么对象中属性一定都是其对应数据类型的默认值
2-抽象类中允许不定义任何的抽象方法，但是此时抽象类对象依然无法进行直接实例化处理
 */

abstract class A66{
    public A66(){//3、调用父类的构造方法
        this.print();//3、调用子类覆写过的方法
    }
    public abstract void print();
}

class B66 extends A66{
    private int num = 100;
    public B66(int num){
        //super(); //2、虽然没有该行语句，但是隐含调用了父类的无参构造方法
        this.num = num;//5、为类中的属性初始化
    }
    public void print(){//5、此时子类对象的属性还没有被传递,this.num=num还没有执行
        System.out.println(this.num);//4、仍为默认值0
    }

}

public class part2_66_抽象类使用限制_1 {
    public static void main(String[] args) {
        B66 b = new B66(66);//返回结果为0，原因分析：1、new 进入类B66的构造方法
        b.print();//6，返回值为66

    }
}
