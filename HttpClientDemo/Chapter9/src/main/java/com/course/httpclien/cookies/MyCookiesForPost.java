package com.course.httpclien.cookies;


import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeMethod
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        HttpGet get = new HttpGet(this.url+uri);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        this.store = client.getCookieStore();
        List<Cookie> cookieList =  store.getCookies();
        for(Cookie cookie:cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name + "\n" + value);
        }
//        for(int x=0; x<cookieList.size();x++){
//            String name = cookieList.get(x).getName();
//            String value = cookieList.get(x).getValue();
//            System.out.println(name + "\n" + value);
//        }

    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void postWithCookiesTest() throws IOException {
        String result;
        String uri = this.bundle.getString("test.post.with.cookies");
        HttpPost post = new HttpPost(this.url+uri);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(store);
        //headers
        post.setHeader("content-type","application/json");
        //传参
        JSONObject param = new JSONObject();
        param.put("name","huhanshan");
        param.put("age","18");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //执行post请求
        HttpResponse response = client.execute(post);
        int status = response.getStatusLine().getStatusCode();
        System.out.println(status);
        if (status==200){
            //获取响应结果
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
            //处理结果，就是判断返回结果是否符合预期
            //将返回的响应结果字符串转化成为json对象
            JSONObject resultJson = new JSONObject(result);
            String name = (String) resultJson.get("huhansan");
            String status_1 = (String) resultJson.get("status");
            System.out.println(name);
            System.out.println(status_1);
            Assert.assertEquals(name,"success");


        }



    }
}
