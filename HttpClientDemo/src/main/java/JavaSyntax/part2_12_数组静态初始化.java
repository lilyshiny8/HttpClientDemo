/*
简化格式：
数据类型 数组名称 [] = {值，值.....}
完整格式：
数据类型 数组名称 [] = new 数据类型[] {值，值.....}

数组的最大缺点是长度固定
 */
public class part2_12_数组静态初始化 {
    public static void main(String[] args) {
        //匿名数组
        System.out.println(new int[] {1,2,3,4}.length);
    }
}
