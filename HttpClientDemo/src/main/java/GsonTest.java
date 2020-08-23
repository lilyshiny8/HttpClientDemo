import com.google.gson.Gson;
import org.testng.annotations.Test;

import static java.lang.Character.getType;

public class GsonTest {
    @Test
    public void test1() {
        Gson gson = new Gson();
        int i = gson.fromJson("100", int.class); //100
        double d = gson.fromJson("\"99.99\"", double.class);  //99.99
        boolean b = gson.fromJson("true", boolean.class);     // true
        String str = gson.fromJson("String", String.class);   // String
        System.out.println(str);

    }



}
