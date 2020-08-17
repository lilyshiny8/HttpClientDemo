package JavaSyntax;

public class part1_14_TypeString {
    public static void main(String[] args) {
        //用"声明
        //char可以描述的只是单一的字符，多个字符用String。String并不是一个基本数据类型，是一个引用数据类型，首字母大写。
        //特殊的是可以按照基本数据类型的使用模式来进行套用
        String name = "ABC";
        String note = "DEF";
        //+ 表示内容的连接操作
        System.out.println(name+note);


        //当数学加号和字符串的连接加号混合
        int numA = 10;
        double numB = 10.2;
        String result = "the result is: " + numA + numB;
        System.out.println(result);//the result is: 1010.2//此时不是数学计算而是连接
        //一旦 + 的操作中有字符串，则所有的数据类型都变为String

        //如果想得到正确的结果，必须用括号来解决
        System.out.println("the result is: "+ (numA+numB));


        //转义字符
        /*
        换行 \n
        制表符即tab \t
        双引号 \"
        单引号 \'
        \ \\
         */
        System.out.println("A \n \"B\" \t\tC");

    }
}
