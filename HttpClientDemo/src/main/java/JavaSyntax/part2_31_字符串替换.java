package JavaSyntax;

public class part2_31_字符串替换 {
    public static void main(String[] args) {
        String str = "hello world";
        //public String replaceAll(String regex,String replacement)
        //public String replaceFirst(String regex,String replacement)
        System.out.println(str.replaceAll("l","_")+"\n"+
                str.replaceFirst("l","-"));

    }
}
