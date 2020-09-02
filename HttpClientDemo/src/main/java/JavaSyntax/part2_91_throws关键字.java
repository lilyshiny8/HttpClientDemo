package JavaSyntax;
/*
如果你现在调用throws声明的方法，纳闷在调用时就必须明确的使用try...catch进行异常捕获。因为该方法有可能产生异常，必须按照异常的方式来进行处理
 */
class MyMath {
    public static int div(int x,int y) throws Exception{
        return x/y;
    }
}
public class part2_91_throws关键字 {
    //jvm处理
    public static void main(String[] args) throws Exception {
        System.out.println(MyMath.div(10,0));
    }

//    public static void main(String[] args) {
//        try {
//            System.out.println(MyMath.div(10,0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
