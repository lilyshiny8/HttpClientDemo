package JavaSyntax;

import java.util.Map;
import java.util.TreeMap;

/*
TreeMap表示可以排序的Map子类，它是按照key的内容来进行排序的
这个排序处理依然按照的是Comparable接口完成的

总结：
1-Collection保存数据的目的是为了输出，Map保存数据的目的是为了根据key查找，找不到返回null
2-Map使用Iterator输出（Map.Entry的作用）

 */
public class part3_149_TreeMap子类 {
    public static void main(String[] args) {
        Map<Integer,String> map = new TreeMap<Integer,String>();
        map.put(3,"33");
        map.put(2,"22");
        map.put(1,"11");
        System.out.println(map);
    }
}
