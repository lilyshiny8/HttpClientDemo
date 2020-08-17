package JavaSyntax;

public class part2_29_字符串比较 {
    public static void main(String[] args) {
        //public boolean equalsIgnoreCase(String anotherString)
        String str1 = "hello";
        String str2 = "geLLo";
        System.out.println(str1.equalsIgnoreCase(str2));
        //public int compareTo(String anotherString)
        System.out.println(str1.compareTo(str2));
        //public int compareToIgnoreCase(String str)
        System.out.println(str1.compareToIgnoreCase(str2));
    }
}
