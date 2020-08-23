import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StringBuffer_demo {
    @Test
    public void test1(){
        StringBuffer params = new StringBuffer();
        String str = "abc";
        params.append(str);
        params.append("123");
        System.out.println(params);
    }
    @Test
    public void test2(){
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name", "&"));
        params.add(new BasicNameValuePair("age", "18"));
        System.out.println(params);
    }
    @Test
    public void test3() {
        int [] arr1 = new int[]{1,2,3};
        for(int x :arr1) {
            System.out.println(x);
        }
    }

}
