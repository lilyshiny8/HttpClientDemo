package gson;

import org.apache.commons.io.FileUtils;
import util.GsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class GsonUtilSample{
    public static void main(String[] args) throws IOException {
        File file = new File(GsonUtilSample.class.getResource("/example.json").getFile());
        String content = FileUtils.readFileToString(file);
        Map data_entity = (Map) GsonUtil.GsonToMaps(content).get("data");
        System.out.println(data_entity.toString());

    }

}
