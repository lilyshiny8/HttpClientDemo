package json;

import Bean.Person;
import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JsonObjectSample {
    public static void main(String[] args) {
//        generateJsonObjectSample();
//        createJsonByMap();
        createJsonByBean();

    }

    private static void generateJsonObjectSample() {
        Object nullObject = null;
        JSONObject person = new JSONObject();
        person.put("name","tony");
        person.put("age",11.1);
        person.put("major",new String[]{"a","b","c"});
//        person.put("car", (Collection<?>) null);// the print result is a array []
        person.put("house",nullObject);
        System.out.println(person);

    }
    private static void createJsonByMap() {
        Map<String,Object> person = new HashMap<String,Object>();
        Object nullObject = null;
        person.put("name","tony");
        person.put("major", new String[]{"a","b","c"});
        person.put("house",nullObject);
        JSONObject transToJsonObject = new JSONObject(person);
        System.out.println(transToJsonObject);

    }
    private static void createJsonByBean() {
        Object nullObject = null;
        Person tony = new Person();
        tony.setName("tony");
        tony.setAge(11.1);
        tony.setCar(nullObject);
        tony.setHas_gf(false);
        tony.setMajor(new String[] {"a","b"});
        tony.setIgnore("can not be seen");
        System.out.println(new JSONObject(tony));
    }
}
