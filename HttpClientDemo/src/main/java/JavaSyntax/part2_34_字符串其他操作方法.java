package JavaSyntax;

public class part2_34_字符串其他操作方法 {
    public static void main(String[] args) {
        //public String trim()
        String str1 = " hello world ";
        System.out.println(str1.trim());
        //public String toUpperCase()
        System.out.println(str1.toUpperCase());
        //public String toLowerCase()

        //public String concat(String str)
        System.out.println(str1.concat("!!!"));
        //public int length()
        int len = str1.length();
        System.out.println(len);
        //public boolean isEmpty()
        System.out.println(str1.isEmpty());

        System.out.println(initCap(str1));

    }
    //实现首字母大写
    public static String initCap(String str) {
        str = str.trim();
        if (str == null || "".equals(str)) {
            return str;
        }
        else if (str.length()>1) {
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
        else
            return str.toUpperCase();
    }

}
