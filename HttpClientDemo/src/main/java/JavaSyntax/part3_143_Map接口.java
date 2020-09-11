package JavaSyntax;
/*
Collection集合的特点是每次进行单个对象的保存
Map的主要功能是查找数据
public interface Map<K,V>

V put(K key,V value)
V get(Object key)
Set<K> keySet()//取得所有的key信息
Collection<V> values()
Set<Map.Entry<K,V>> entrySet()//将Map集合变为Set集合

Map本身是一个接口，要使用Map必须通过子类进行对象的实例化
HashMap
Hashtable
TreeMap
ConcurrentHashMap

HashMap和Hashtable的区别
HashMap----性能，异步处理，性能高----安全性，非线程安全---null操作，允许存放null
Hashtable--性能，同步处理，性能较低---线程安全-----------不允许key value为null否则出现NullPointerException


 */

import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class part3_143_Map接口 {
    /*
    Map查找的时间复杂度complexity为n

     */
    @Test
    public void testHashMap(){
        Map<Integer,String> map = new HashMap<Integer,String>();
        //Hash 是无序的
        map.put(3,"3");
        map.put(1,"1");
        map.put(2,"2");
        System.out.println(map);
//        System.out.println(map.get(1));
//        Set<Integer> set = map.keySet();
//        Iterator<Integer> iter = set.iterator();
//        while (iter.hasNext()){
//            Integer key = iter.next();
//            String value = map.get(key);
//            System.out.println(key+"="+value);
//        }

    }
    @Test
    public void testHashtable(){
        Map<Integer,String> map = new Hashtable<Integer, String>();
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");
        map.put(4,null);//java.lang.NullPointerException
        map.put(null,null);
        System.out.println(map);
    }
/*
ConcurrentHashMap的特点 = Hashtable的线程安全性 + HashMap的高性能
java.util.concurrent

 */
    @Test
    public void testConcurrentHashMap(){
        Map<Integer,String> map = new ConcurrentHashMap<Integer, String>();
        map.put(1,"1");
        map.put(2,"2");
        map.put(3,"3");
        System.out.println(map);
    }
}
