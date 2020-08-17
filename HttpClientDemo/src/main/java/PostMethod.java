import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostMethod {


    @Test
    public void test1(){

        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://10.22.16.66:8000/api/order_items");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void doPostTestTwo() {

        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建Post请求
        HttpPost httpPost = new HttpPost("http://dummy.restapiexample.com/api/v1/create");
        // 我这里利用阿里的fastjson，将Object转换为json字符串;
        // (需要导入com.alibaba.fastjson.JSON包)
        User user = new User();
        user.setName("MarryAM");
        user.setSalary(12312);
        user.setAge(23);
        String jsonString = JSON.toJSONString(user);
//        System.out.println(jsonString.getClass().getTypeName());

//        //json格式的String转为Map，方法一
//        Gson gson = new Gson();
//        Map<String,Object> map = new HashMap<String, Object>();
//        map = gson.fromJson(jsonString,map.getClass());
//        String name = (String) map.get("name");
//        System.out.println(name);
//        //方法二
//        Map<String,Object> res = json2map(jsonString);
//        System.out.println("res ="+"\n"+res);
//        System.out.println(res.get("name"));



        StringEntity entity = new StringEntity(jsonString, "UTF-8");
//        System.out.println(entity);

        // post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println(responseEntity.getClass().getTypeName());


            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                //get salary's value
                String responseEntitytoString = EntityUtils.toString(responseEntity);
                Map<String,Object> res = json2map(responseEntitytoString);

//                Object data =  res.get("data");
                LinkedTreeMap data = (LinkedTreeMap) res.get("data");
//                System.out.println(data.getClass().getTypeName());

                String dataToString = data.toString();
                Map<String, Object> res1 = json2map(dataToString);
                System.out.println("salary is:"+res1.get("salary"));


//                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
//                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));


            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
//        } finally {
//            try {
//                // 释放资源
//                if (httpClient != null) {
//                    httpClient.close();
//                }
//                if (response != null) {
//                    response.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    public class User {
        private String name;
        private double salary;
        private Integer age;
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setSalary(double salary){
            this.salary = salary;
        }
        public double getSalary() {
            return this.salary;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        public Integer getAge() {
            return this.age;
        }
        @Override
        public String toString(){
            return name + "," + salary + "," + age;
        }
    }

    public static Map<String, Object> json2map(String str_json) {
        Map<String, Object> res = null;
        try {
            Gson gson = new Gson();
            res = gson.fromJson(str_json, new TypeToken<Map<String, Object>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
        }
        return res;
    }

}
