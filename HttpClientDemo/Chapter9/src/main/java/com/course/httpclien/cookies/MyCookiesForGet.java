package com.course.httpclien.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
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
    public void getWithCookiesTest() throws IOException {
        String result;
        String uri = this.bundle.getString("test.get.with.cookies");
        HttpGet get = new HttpGet(this.url+uri);
        DefaultHttpClient client = new DefaultHttpClient();

        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        //get status
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if (statusCode==200){
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }else
            assert 1==0;

    }

}
