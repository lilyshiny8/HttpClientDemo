package gson;

import Bean.Person;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class GsonCreateSample {
    public static void main(String[] args) {
        createByBean();


    }

    private static void createByBean() {
        Object nullObject = null;
        Person tony = new Person();
        tony.setName("tony");
        tony.setAge(11.1);
        tony.setCar(nullObject);
        tony.setHas_gf(false);
        tony.setMajor(new String[] {"a","b"});
        tony.setIgnore("can not be seen");
        //GsonBuilder
        GsonBuilder gsonBuilder = new GsonBuilder();
        //打印出来格式化后的json  setPrettyPrinting
        gsonBuilder.setPrettyPrinting();
        //回调函数 定制名称的策略
        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                if(field.getName().equals("name")){
                    return "NAME";
                }
                return field.getName();
            }
        });
        Gson gs = gsonBuilder.create();
        System.out.println(gs.toJson(tony));

    }
    private static void createByMap(){
        Map<String,Object> tony = new HashMap<String,Object>();
        Object nullObject = null;
        tony.put("name","tony");
        tony.put("major", new String[]{"a","b","c"});
        tony.put("house",nullObject);
        Gson gs = new Gson();
        System.out.println(gs.toJson(tony));

    }
}
