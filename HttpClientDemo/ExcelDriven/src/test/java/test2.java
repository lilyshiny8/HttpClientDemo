import com.frame.http.request.RequestMethod;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class test2 {
    @Test
    public void t1(){
        RequestMethod str = RequestMethod.GET;
        System.out.println(str);

    }
    @Test
    public void t2(){
        JSONObject param = new JSONObject();
        param.put("name","huhanshan");
        param.put("age","18");
        StringEntity inputEntity = new StringEntity(param.toString(),"utf-8");
        System.out.println(inputEntity);
    }
    @Test
    public void t3(){
        JSONObject param = new JSONObject();
        param.put("name","huhanshan");
        param.put("age","18");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");

        System.out.println(entity);
    }
}
