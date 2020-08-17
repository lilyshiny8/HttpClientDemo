/*
字符串常量是String的匿名对象
 */
public class part2_23_字符串为匿名对象 {
    public static void main(String[] args) {

        String input = null;
        //exception:  NullPointerException
//        System.out.println(input.equals("hello"));
        System.out.println("hello".equals(input));
    }
}
