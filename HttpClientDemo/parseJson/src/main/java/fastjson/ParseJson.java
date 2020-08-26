package fastjson;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ParseJson {
    @Test
    public void test1() throws IOException {
        File file = new File(ParseJson.class.getResource("/fastjson.json").getFile());
        String content = FileUtils.readFileToString(file);
        JSONObject obj = JSONObject.parseObject(content);
        JSONObject state = (JSONObject) obj.getJSONArray("container_records").get(0);
        JSONObject fragment = (JSONObject) state.getJSONObject("state").getJSONObject("aDataItem").getJSONArray("fragments").get(0);
        String DocumentCreateDatetime = fragment.getJSONObject("fragment").getJSONObject("metadata").getString("DocumentCreateDatetime");
        System.out.println(DocumentCreateDatetime);


    }
}
