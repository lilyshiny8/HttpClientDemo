package JavaSyntax;
/*
final被称为终结器。可以用final来定义类，方法及属性
1-使用final定义的类不能够有子类---比如说String类就有final
2-使用final定义的方法不能够被子类所覆写
3-使用final定义的变量就成为了常量，常量必须在声明时赋值，并且不允许修改
但是在开发过程中如果要定义常量，一般会使用public static final来定义全局常量
所有常量的标识符必须全部采用大写字母的形式
 */
class A{
    //被final定义的变量
    private final int num = 100;
    public A(){
        System.out.println("A's constructor");
    }
    //被final定义的父类方法
    public final void fun(){
        //cannot assign a value to a final variable 'num'
//        num=200;

    }
}
class B extends A{
    //overridden method is final
//    public void fun(){}
   


    }

public class part2_63_final关键字 {
}
