package gson;

import com.google.gson.internal.$Gson$Preconditions;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.commons.io.FileUtils;
import util.GsonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class GsonUtilSample{
    public static void main(String[] args) throws IOException {
        test2();

    }
    public static void gsonToString() throws IOException {
        File file = new File(GsonUtilSample.class.getResource("/json1.json").getFile());
        String content = FileUtils.readFileToString(file);
        String str = GsonUtil.GsonString(content);
        System.out.println(str);
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
//        List entity = GsonUtil.GsonToList(content,Object.class);
//        for(Object x:entity){
//            System.out.println(x);
//            Map y = (Map) x;
//            System.out.println(y.get("a"));
//        }
        List entity = GsonUtil.GsonToList(content,List.class);
        Map member = (Map) entity.get(0);
        System.out.println(member);

    }
    public static void test1() throws IOException {
        File file = new File(GsonUtilSample.class.getResource("/json1.json").getFile());
        String content = FileUtils.readFileToString(file);
        List<Map<String,String>> list= (List<Map<String, String>>) GsonUtil.GsonToMaps(content).get("jsonToList");
        for(Map<String,String> map:list){
            Set<Map.Entry<String,String>> set = map.entrySet();
            for (Map.Entry<String,String> x: set){
                System.out.println(x.getKey());
                System.out.println(x.getValue());
            }

        }
    }
    public static void gsonToListMap() throws IOException {
        File file = new File(GsonUtilSample.class.getResource("/json1.json").getFile());
        String content = FileUtils.readFileToString(file);
        Map listMap = (Map) GsonUtil.GsonToMaps(content).get("params");
        System.out.println(listMap);
        Set<Map.Entry<String,String>> set = listMap.entrySet();
        for(Map.Entry<String,String> x : set){
            System.out.println(x.getKey()+"="+x.getValue());
        }

    }

    public static void gsonToList1() throws IOException{
        File file = new File(GsonUtilSample.class.getResource("/json1.json").getFile());
        String content = FileUtils.readFileToString(file);
        List list = (List) GsonUtil.GsonToMaps(content).get("jsonToList");

        for(Object map:list){
            System.out.println(map);
        }

    }
    public static void test2() throws IOException {
        File file = new File(GsonUtilSample.class.getResource("/fastjson.json").getFile());
        String content = FileUtils.readFileToString(file);
        List list = (List)GsonUtil.GsonToMaps(content).get("container_records");
        Map firstEle = (Map) list.get(0);
        Map state = (Map) firstEle.get("state");
        Map aDataItem = (Map)state.get("aDataItem");
        List fragments = (List) aDataItem.get("fragments");
        Map firstFragment = (Map)fragments.get(0);
        Map fragment = (Map) firstFragment.get("fragment");
        Map metadata = (Map)fragment.get("metadata");
        String DocumentCreateDatetime = (String) metadata.get("DocumentCreateDatetime");
        System.out.println(DocumentCreateDatetime);
    }


}
