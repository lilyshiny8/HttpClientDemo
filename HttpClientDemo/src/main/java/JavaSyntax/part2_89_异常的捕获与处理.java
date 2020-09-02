package JavaSyntax;
/*
异常是导致程序中断执行的一种指令流。程序之中出现异常并且没有被合理处理的话，就会导致程序终止执行

throws 在进行方法定义的时候，如果要告诉调用者本方法可能产生那些异常，可以throws进行声明。
 */

public class part2_89_异常的捕获与处理 {
    public static void main(String[] args) {
        System.out.println("start");
        try{
            System.out.println(10/0);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("不管是否有异常都执行此语句");
        }
        System.out.println("end");
    }
}
