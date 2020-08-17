package JavaSyntax;

public class part2_33_字符串截取 {
    public static void main(String[] args) {
        String str = "hello world";
        //public String substring(int beginIndex)
        String result = str.substring(2);
        System.out.println(result);
        //public String substring(int beginIndex,int endIndex)
        String res = str.substring(2,6);
        System.out.println(res);
    }
}
