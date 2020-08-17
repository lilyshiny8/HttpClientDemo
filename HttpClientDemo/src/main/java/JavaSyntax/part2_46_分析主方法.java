package JavaSyntax;

/*
如果一个方法定义在主类之中，并且由主方法直接调用，那么该方法的定义如下
public static 返回值类型 方法名称（参数列表） {
}

public: 表示的是公共的，主方法作为起点必须可以随意访问
static: 执行java程序的时候执行的是一个类名称”part2_46_分析主方法“ 所以表示不受实例化对象限制
void： 主方法是一切的起点；
main: 系统定义好的方法名称，不能变
String[] args: 该类执行时所需要的相关参数
 */
public class part2_46_分析主方法 {
    public static void main(String[] args) {
//        new part2_46_分析主方法().print();
        for (int x=0; x<args.length; x++){
            System.out.println(args[x]);
        }

    }
    public void print(){
        System.out.println("hello world");
    }
}
