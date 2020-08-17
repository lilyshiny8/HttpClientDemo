package JavaSyntax;

public class part1_24_方法的基本定义 {
    /*
    public static 方法返回值 方法名称 ([参数类型 变量, ...]) {
    方法体代码；
    [return [返回值];]
    }
     */

    //方法的返回值有以下两类
    //void 没有返回值
    //数据类型（基本类型和引用类型）
    public static void main(String[] args) {

        print();
        print1("Hello!");
        int result = add(10,20);
        System.out.println(result);
        //
        System.out.println(add(100,200));
        //
        print2(10);
        print2(20);

    }
    //无参数无返回
    public static void print() {
        System.out.println("***********");
    }
    //有参数无返回
    public static void print1(String msg) {
        System.out.println(msg);
    }
    //有参数有返回
    public static int add(int x, int y) {
        return x + y ;
    }
    //如果某一个方法上使用void定义，该方法中可以直接利用return来结束调用
    public static void print2(int x) {
        if (x == 20){
            return;
        }
        System.out.println("x = " +x);
    }
}

