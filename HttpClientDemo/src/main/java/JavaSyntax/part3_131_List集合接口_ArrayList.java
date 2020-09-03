package JavaSyntax;
/*
public interface List<E> extends Collection<E>
这List接口中有两个重要的扩充方法：
public E get(int index)  ---根据索引取得保存数据
public E set(int index,E element)---修改数据
List子接口与Collection接口相比最大的特点在于其有一个get方法，可以根据索引取得内容
但List本身还属于接口，要想取得接口的实例化对象，就必须有子类。在List接口下有三个常用子类：
1-ArrayList
public class ArrayList<E>
extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, Serializable

2-Vector

3-LinkedList

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class part3_131_List集合接口_ArrayList {
    public static void main(String[] args) {
        //ArrayList是一个针对于list接口的数组操作实现
        //ArrayList可以为List实例化，也可以为Collection实例化
        List<String> all = new ArrayList<String>();//此时的集合里面只允许保存String数据类型
        all.add("Hello");
        all.add("Hello");
        all.add("World");
        all.remove("Hello");
        System.out.println(all);
        System.out.println(all.size()+","+all.isEmpty());
        System.out.println(all.contains("ABC"));
        System.out.println(all.contains("Hello"));
        System.out.println(all);
        //get-1
        System.out.println(all.get(1));
       //get-2
        for(int x=0; x<all.size();x++){
            System.out.println(all.get(x));
        }


        //Collection没有get方法
        Collection<String> all1 = new ArrayList<String>();
        all1.add("A");
        all1.add("B");
        all1.add("C");
        //操作以Object形式返回，那么就有可能需要进行向下壮行，有可能造成ClassCastException
        Object [] result = all1.toArray();
        System.out.println(Arrays.toString(result));





    }
}
