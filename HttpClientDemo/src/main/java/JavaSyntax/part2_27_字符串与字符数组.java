package JavaSyntax;

/*
字符串就是一个字符数组，在String类中提供了字符串合字符数组相互转换的方法
 */
public class part2_27_字符串与字符数组 {
    public static void main(String[] args) {
        //String(char[] value)
        char[] ss = {'h','e','l','l','o'};
        String str1 = new String(ss);
//        System.out.println(str1);
        //String(char[] value, int offset, int count)
        String str2 = new String(ss,1,2);
//        System.out.println(str2);
        //charAt(int index)
        char a = str1.charAt(1);
//        System.out.println(a);
        //toCharArray()

        char[] charArr = str1.toCharArray();
        System.out.println(charArr.getClass().getTypeName());
        for (int x=0; x<charArr.length; x++) {
            charArr[x] -= 32; //转为大写
//            charArr[x] = (char)(charArr[x]-32);
            System.out.print(charArr[x]);
        }
        System.out.println();
        String str3 = "abc1def";
        String result = isNumber(str3) ? "contains number:yes" : "contains number:no";
        System.out.println(result);
     }
     public static boolean isNumber(String str) {
        char charArr [] = str.toCharArray();
        for (int x=0; x<charArr.length; x++) {
            if (charArr[x] >= '0' && charArr[x] <= '9') {
                return true;
            }
        }
        return false;
     }


}
