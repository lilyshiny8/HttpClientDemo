package gson;

import org.apache.commons.io.FileUtils;
import util.GsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GsonUtilSample{
    public static void main(String[] args) throws IOException {
        gsonToList();

    }
    private static void gsonToMaps() throws IOException {
        File file = new File(GsonUtilSample.class.getResource("/example.json").getFile());
        String content = FileUtils.readFileToString(file);
        Map data_entity = (Map) GsonUtil.GsonToMaps(content).get("data");
        Map exceptions = (Map) data_entity.get("exceptions");
        List nodes = (List) exceptions.get("nodes");
        for(Object x: nodes){
            System.out.println(x);
        }
//        System.out.println(nodes.toString());

    }
    private static void gsonToList() throws IOException {
        File file = new File(GsonUtilSample.class.getResource("/listExample.json").getFile());
        String content = FileUtils.readFileToString(file);
        List entity = GsonUtil.GsonToList(content,Object.class);
//        List entity = GsonUtil.GsonToList(content,List.class);
//        Map member = (Map) entity.get(0);
//        System.out.println(member);
        for(Object x:entity){
            System.out.println(x);
            Map y = (Map) x;
            System.out.println(y.get("a"));
        }
    }

}
