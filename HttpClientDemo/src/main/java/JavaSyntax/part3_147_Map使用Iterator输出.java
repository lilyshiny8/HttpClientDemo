package JavaSyntax;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Map接口没有Iterator()方法

Set<Map.Entry<K,V>> entrySet()//将Map集合变为Set集合
 */
public class part3_147_Map使用Iterator输出 {
    @Test
    public void testIterator(){
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        Set<Map.Entry<Integer,String>> set = map.entrySet();//1，将Map集合变为Set集合
        Iterator<Map.Entry<Integer,String>> iter = set.iterator();//2，实例化Iterator接口
        while (iter.hasNext()){//3，迭代输出，去除每一个Map.Entry对象
            Map.Entry<Integer,String> me = iter.next();//4,去除Map.Entry
            System.out.println(me.getKey()+"="+me.getValue());//5，取得key和value
        }
    }
}
