package JavaSyntax;

public class part1_26_方法递归调用 {
    //方法必须有一个递归的结束条件
    //方法在每次递归处理的时候一定要做出一些变更

    public static void main(String[] args) {
        System.out.println(sum(100));
        System.out.println(mul(60));
    }
    public static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sum (num -1);
    }
    public static double mul(int num) {
        if (num == 1) {
            return 1;
        }
        return num * mul (num -1);
    }
}
