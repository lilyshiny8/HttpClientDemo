import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HttpContext {
    public CookieStore store;
    @BeforeMethod
    public  void getCookieStore() throws IOException {
        String result;
        HttpGet get = new HttpGet("http://localhost:8888/getCookie");
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        this.store = client.getCookieStore();
        System.out.println(this.store);
    }
    @Test
    public void keepAliveDemo3(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient1 = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8888/post/with/cookies");


        CloseableHttpResponse response = null;
        String postEntity = null;

        HttpClientContext context = HttpClientContext.create();
        context.setCookieStore(this.store);

        httpPost.setHeader("content-type","application/json");


        JSONObject param = new JSONObject();
        param.put("name","tony");
        param.put("age","18");
        StringEntity inputEntity = new StringEntity(param.toString(),"utf-8");
        System.out.println(inputEntity);
        httpPost.setEntity(inputEntity);

        try {
            response = httpClient.execute(httpPost,context);
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            postEntity = EntityUtils.toString(entity,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(postEntity);
        System.out.println("==================================");
        HttpGet httpGet = new HttpGet("http://www.tutorialspoint.com/");
        CloseableHttpResponse response1 = null;
        try{
            response1 = httpClient1.execute(httpGet,context);
            String getEntity = EntityUtils.toString(response1.getEntity(),"utf-8");
            System.out.println(getEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
