package json;




import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class ParseJsonSample {
    public static void main(String[] args) throws IOException {
        File file =  new File(ParseJsonSample.class.getResource("/tony.json").getFile());
        String content = FileUtils.readFileToString(file);
        JSONObject jsonObject = new JSONObject(content);
//        System.out.println(jsonObject.getJSONArray("major"));
//        System.out.println(jsonObject.getJSONArray("major").get(0));
        //通过isNull判断键存在，增加脚本健壮性
        if(!jsonObject.isNull("major")) {
            JSONArray jsonArray = jsonObject.getJSONArray("major");
            for(Object str : jsonArray){
                System.out.println(str.getClass().getTypeName());
//            String member = (String) str;
//            System.out.println(member.getClass().getTypeName());
            }
            for(int x=0; x<jsonArray.length();x++){
                String memeber = (String) jsonArray.get(x);

            }
        }
        if(jsonObject.isNull("name")) {
            System.out.println(jsonObject.getString("name"));
        }

    }
}
