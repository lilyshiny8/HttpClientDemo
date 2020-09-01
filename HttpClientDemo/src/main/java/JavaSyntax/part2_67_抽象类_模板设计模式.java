package JavaSyntax;

import javax.swing.plaf.SliderUI;

/*
抽象类的最大特点在于强制规定了子类的实现结构，除了这个特点，抽象类还可以起到一个模板的作用。

抽象类在实际的使用过程之中会定义一些固化的模式（command），它只能接收几种特定的模式
但是每种指令的具体实现由子类负责完成，父类只做了方法的约定
最具有代表性的就是后面要学习的servlet
 */
//定义抽象的行为
abstract class Action{
    public static final int EAT = 1;
    public static final int SLEEP = 5;
    public static final int WORK = 10;
    public void command(int cmd){
        switch (cmd){
            case EAT:
                this.eat();
                break;
            case SLEEP:
                this.sleep();
                break;
            case WORK:
                this.work();
                break;
            case EAT+ SLEEP+WORK:
                this.eat();
                this.sleep();
                this.work();
        }
    }
    public abstract void eat();
    public abstract void sleep();
    public abstract void work();
}
class Pig extends Action{
    public void eat(){
        System.out.println("pig - eat");
    };
    public void sleep(){
        System.out.println("pig - sleep");
    };
    public void work(){
        System.out.println();
    };
}
public class part2_67_抽象类_模板设计模式 {
    public static void main(String[] args) {
        fun(new Pig());

    }
    public static void fun(Action action) {
        action.command(Action.EAT+Action.SLEEP+Action.WORK);
    }
}
