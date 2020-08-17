package JavaSyntax;

public class part2_30_字符串查找 {
    public static void main(String[] args) {
        //public boolean contains(CharSequence s)
        String str1 = "hello world!";
        String str2 = "o";
//        System.out.println(str1.contains(str2));
        //public int indexOf(String str)
//        System.out.println(str1.indexOf(str2));
//        System.out.println(str1.indexOf('a'));
        //public int indexOf(String str,int fromIndex)
//        System.out.println(str1.indexOf(str2,2));

        //public int lastIndexOf(String str)
        System.out.println(str1.lastIndexOf(str2));
        //public int lastIndexOf(String str,int fromIndex)
//        System.out.println(str1.lastIndexOf(str2,5));
        //public boolean startsWith(String prefix)
//        System.out.println(str1.startsWith("h"));
        //public boolean startsWith(String prefix,int toffset)
        System.out.println(str1.startsWith("wor",6));
    }
}
