package JavaSyntax;

public class part1_21_循环结构 {
    public static void main(String[] args) {
        //while
        /*
        循环的初始化内容
        while (循环的结束条件判断) {
            循环语句；
            修改循环结束条件判断；
        }
         */
         /*
        循环的初始化内容
         do {
            循环语句；
            修改循环结束条件判断；
        }while (循环的结束条件判断);
         */
        //for
        int num = 1;
        int result = 0;
        while (num <= 100) {
            result = result + num;
            num ++;
        }
        System.out.println(result);

        //while 和 do..while的区别在于，条件不满足while一次也不执行，do..while会执行一次
        int num1 = 1;
        int result1 = 0;
        do {
            result1 = result1 + num1;
            num1 ++;
        }while (num1 <= 100);
        System.out.println(result1);

        int result3 = 0;
        //1、循环初始化    int x = 0
        //2、判断循环条件   x <= 100 ;
        //4、循环条件变更   x ++
        //5、判断循环条件，在2、3、4、5之间循环
        for (int x = 0; x <= 100 ; x ++) {
            result3 = result3 + x;//3、循环体操作
        }
        System.out.println(result3);
    }

}
//循环使用原则：
//对于不知道循环次数，直到循环结束条件的使用while。
//如果已经明确知道循环次数，则使用for循环。