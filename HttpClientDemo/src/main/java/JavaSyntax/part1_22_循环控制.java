package JavaSyntax;

public class part1_22_循环控制 {
    public static void main(String[] args) {
        //continue
        //执行到此语句时将跳过循环的剩余部分。跳过当前循环
        for (int x = 0; x<10 ; x ++) {
            if (x == 3) {
                continue;//执行此语句之后循环体的后面代码不执行了。空出一次循环。
            }
            System.out.println("x="+x);
        }
        //break
        //退出整个循环


        //其他语言中有一种goto的功能，java中没有该功能。但是可以使用continue实现与之一样的功能
        mp: for (int xx = 0; xx < 5; xx ++ ) {
                for (int yy = 0; yy < 3; yy ++ ) {
                    if (xx > 2) {
                        continue mp;
                    }
                    System.out.println("xx = "+xx+", yy="+yy);
                }
        }

    }
}
