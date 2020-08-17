package JavaSyntax;

public class part1_16_三目运算符 {
    public static void main(String[] args) {
        //三目运算符
        //三目是一种赋值运算，他指的是根据条件来进行判断
        //数据类型 变量 = 布尔表达式 ？ 条件满是赋值内容 ：条件不满足时赋值内容
        int x = 10;
        int y = 20;
        int z = 30;
        int result = x>y ? x:z;
        System.out.println("result = " + result);

    }
}
