package JavaSyntax;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
Set接口并没有对Collection接口进行扩充。而List对Collection进行了扩充
public interface Set<E> extends Collection<E>
两个常用的子类
HashSet（无序存储），TreeSet（有序存储）

Hash算法
 */
public class part3_136_Set接口常用子类 {
    public static void main(String[] args) {
        Set<String> all = new HashSet<String>();
        all.add("D");
        all.add("B");
        all.add("E");
        all.add("A");
        System.out.println(all);

        //TreeSet使用的是要给升序排列的模式完成的
        Set<String> all1 = new TreeSet<String>();
        all1.add("D");
        all1.add("D");
        all1.add("E");
        all1.add("A");
        System.out.println(all1);

    }
}
