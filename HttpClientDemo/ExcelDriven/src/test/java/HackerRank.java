import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HackerRank {
    public static void main(String[] args) throws IOException {
        List<Map<Integer,Number>> list = HackerRankClass.getData();
        System.out.println(list);
    }

}
class HackerRankClass{
    public static List<Map<Integer,Number>> getData() throws IOException {
        List<Map<Integer,Number>> dataList = new ArrayList<Map<Integer, Number>>();
        String currentPage=null;
        Integer perPage=0;
        Integer totalNum=0;
        Integer totalPages=0;
        //get the total page number
        ResponseResult result = getMethod(1);
        if (result.getStatus() == 200) {
            JSONObject jsonObject = new JSONObject(result.getEntity());
            currentPage = (String) jsonObject.get("page");
//            System.out.println(currentPage);
            perPage = (Integer) jsonObject.get("per_page");
            totalNum = (Integer) jsonObject.get("total");
            totalPages = (Integer) jsonObject.get("total_pages");
            int int1=1;
        }

        for(int x=0; x<totalPages;x++){
            JSONObject jsonObject = new JSONObject(result.getEntity());
            JSONArray data = (JSONArray) jsonObject.get("data");
            for(int y = 0; y<data.length();y++){
                JSONObject dataMeb = (JSONObject) data.get(y);
                String status = (String) dataMeb.get("status");
                if("MALFUNCTIONING".equals(status)){
                    JSONObject operatingParams = (JSONObject) dataMeb.get("operatingParams");
//                    System.out.println(operatingParams.get("slack").getClass().getTypeName());

                    Number slack = (Number) operatingParams.get("slack");
                    Integer id = (Integer) dataMeb.get("id");
                    Map<Integer,Number> map = new HashMap<Integer, Number>();
                    map.put(id,slack);
//                    System.out.println("map="+map);
                    dataList.add(map);

                }
            }
        }
            return dataList;
    }
    public static ResponseResult getMethod(String status,Integer page) throws IOException {
        String url = "https://jsonmock.hackerrank.com/api/iot_devices";
        String urlWithParam = url+"/search?"+"status="+status+"&"+"page="+page;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(urlWithParam);
        CloseableHttpResponse response = client.execute(get);
        String entity = EntityUtils.toString(response.getEntity());
        ResponseResult result = new ResponseResult();
        result.setEntity(entity);
        result.setStatus(response.getStatusLine().getStatusCode());
        return result;
    }
    public static ResponseResult getMethod(String status) throws IOException {
        String url = "https://jsonmock.hackerrank.com/api/iot_devices";
        String urlWithParam = url+"/search?"+"status="+status;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(urlWithParam);
        CloseableHttpResponse response = client.execute(get);
        String entity = EntityUtils.toString(response.getEntity());
        ResponseResult result = new ResponseResult();
        result.setEntity(entity);
        result.setStatus(response.getStatusLine().getStatusCode());
        return result;
    }
    public static ResponseResult getMethod(Integer page) throws IOException {
        //"https://jsonmock.hackerrank.com/api/iot_devices/search?status=RUNNING&page=1"
        String url = "https://jsonmock.hackerrank.com/api/iot_devices";
        String urlWithParam = url+"/search?"+"page="+page;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(urlWithParam);
        CloseableHttpResponse response = client.execute(get);
        String entity = EntityUtils.toString(response.getEntity());
        ResponseResult result = new ResponseResult();
        result.setEntity(entity);
        result.setStatus(response.getStatusLine().getStatusCode());
        return result;
    }

}
class ResponseResult{
    private String entity;
    private int status;
    public String getEntity() {
        return entity;
    }
    public void setEntity(String entity) {
        this.entity = entity;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
