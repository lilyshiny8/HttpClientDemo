package JavaSyntax;
/*
throw时直接编写在语句之中的，表示人为的进行异常的抛出。
一般而言throw和break、continue、return都需要结合if判断使用

throw和throws的区别？
-throw用于方法内部主要表示进行手工的异常抛出
-throws在方法声明上使用，明确的告诉用户本方法可能产生的异常，同时该方法可能不处理此异常
 */
public class part2_92_throw {
    public static void main(String[] args) {
        try {
            throw new Exception("人为抛出异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
