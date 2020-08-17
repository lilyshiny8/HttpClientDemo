package JavaSyntax;

public class part1_23_循环嵌套 {
    public static void main(String[] args) {
        //九九乘法表
//        for (int x = 1 ; x <= 9; x ++) {
//            for (int y = 1 ; y <= x; y ++ ) {
//                System.out.println(x+"*"+"y"+"="+x * y+"\t");
//            }
//            System.out.println();//换行
//        }

        //打印三角形
        int line = 10 ;
        for (int x = 0 ; x < line ; x ++) { //控制行
            for (int y = 0 ; y < line - x ; y ++) { //空格
                System.out.println(" ");
            }
            for (int y = 0; y<x ; y ++) { //打印*
                System.out.println("* ");
            }
            System.out.println();
        }
    }
}
