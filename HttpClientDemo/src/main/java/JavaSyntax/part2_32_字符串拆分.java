package JavaSyntax;

public class part2_32_字符串拆分 {
    public static void main(String[] args) {
        //public String[] split(String regex)
        //public String[] split(String regex,int limit)
        String str = "hello world hello String";
        String[] result = str.split(" ");
        CommonLib.printArr(result);
        String[] result1 = str.split(" ",3);
        CommonLib.printArr(result1);

        //转义 . |
        String str1 = "192.168.1.1";
        String[] result2 = str1.split("\\.");
        CommonLib.printArr(result2);

    }

}
