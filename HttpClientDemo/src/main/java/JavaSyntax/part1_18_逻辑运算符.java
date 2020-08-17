package JavaSyntax;

public class part1_18_逻辑运算符 {
    public static void main(String[] args) {
        //!
        System.out.println(! (10 > 20));
        //&
//        if (10 > 20 & 10 /0 ==0){
//            System.out.println("all the boolean expression are excuted");
//        }//Exception in thread "main" java.lang.ArithmeticException: / by zero
        //&&(短路与)
        if (10 > 20 && 10 / 0 == 0){
            System.out.println("Break the sentence when there is one false in boolean expression");
        }
        // |
        // ||(段落或)
        if (10 != 20 || 10 / 0 == 0){
            System.out.println("Break the sentence when there is one ture in boolean expression");
        }
    }
}
