package JavaSyntax;

public class part1_20_分支结构 {
    public static void main(String[] args) {
        /*
        if (布尔表达式) {
        ;
        } else {
        ;
        }
         */


        /*
        if (布尔表达式) {
        ;
        } else if (布尔表达式) {
        ;
        } else {
        ;
        }
         */

        /*
        switch (数字 | 枚举 | 字符 | 字符串) {
            case 内容1 : {
                ;
                [break;]//可选的break语句
            }
            case 内容2 : {
                ;
                [break;]//可选的break语句
            }
            [default: {
                条件都不满足时执行的语句；//可加可不加
                [break;]
            }]
        }
        //swich这种开发语句会在满足的case语句之后一直执行直到遇见break或者代码结束
         */
        int ch = 5;
        switch (ch) {
            case 1 :{
                System.out.println("1");
                break;
            }
            case 2 : {
                System.out.println("2");
                break;
            }
            default: {
                System.out.println("Don't meet any branch");
                break;
            }
        }
    }
}
