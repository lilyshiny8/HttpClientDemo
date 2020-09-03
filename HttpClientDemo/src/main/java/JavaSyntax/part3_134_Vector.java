package JavaSyntax;
/*
ArrayList与Vector的区别
ArrayList--历史时间
Vector
 */
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class part3_134_Vector {
    public static void main(String[] args) {
        List<String> all = new Vector<String>();
        all.add("Hello");
        all.add("World");
        System.out.println(all);
        all.contains("Hello");
    }
}
