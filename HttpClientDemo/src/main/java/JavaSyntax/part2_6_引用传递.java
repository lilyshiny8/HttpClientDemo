package JavaSyntax;

public class part2_6_引用传递 {
    /*
    引用传递分析
    引用的本质在于别名，而这个别名只不过是放在栈内存中，即一块堆内存可以被多个栈内存所指向。
     */
    public static void main(String[] args) {
        Person per1 = new Person();
        per1.name = "a";
        //此步骤就是引用传递的操作
        Person per2 = per1;//采用同样的类型接收
        per2.name = "b";
        per1.info();


        //进一步看引用传递
        Person perA = new Person();
        Person perB = new Person();
        perA.name = "A";
        perB.name = "B";
        perB = perA;//perB指向perA的堆内存空间，perB原来的内存空间成为垃圾内存
        perB.name = "BB";
        perA.info(); //name = BB

        /*
        垃圾空间指的是没有任何栈内存指向的堆内存空间，所有的垃圾空间将不定期被Java中的垃圾收集器（garbage collector）进行回收以实现内存空间的释放。
        不过从实际开发来说，虽然java提供有GC，但是GC也会造成程序性能的下降，所以开发过程中控制好对象的产生数量，即：无用的数量尽量少产生；

         */

    }


}

