package JavaSyntax;
/*
集合的标准输出模式，四种手段：

看见集合输出就使用Iterator

 */

import org.testng.annotations.Test;

import java.util.*;

public class part3_139_集合输出 {
    //1-Iterator
    //public boolean hasNext()
    //public E next()
    //public default void remove()
    @Test
    public void testIterator(){
        List<String> all = new ArrayList<String>();
        all.add("a");
        all.add("b");
        all.add("c");
        Iterator<String> iter = all.iterator();
        while(iter.hasNext()){
            String str = iter.next();
            if("a".equals(str)){
                all.remove("a");//用List的remove方法
//                iter.remove();//java.util.ConcurrentModificationException//用Iterator的remove方法
                continue;
            }
            System.out.println(str);
        }
    }
    //Iterator只能够由前向后进行内容的迭代处理，双向迭代需要使用Iterator的子接口ListIterator
    /*
    public interface ListIterator<E> extends Iterator<E>
    public boolean hasPrevious()
    public E previous()//取得上一个元素
    ListIterator是由List接口支持的，List接口提供方法取得ListIterator的接口对象：
    public ListIterator<E> listIterator()
     */
    @Test
    public void testListIterator() {
        List<String> all = new ArrayList<String>();
        all.add("a");
        all.add("b");
        all.add("c");
        ListIterator<String> iter = all.listIterator();
        //由前向后输出
        while(iter.hasNext()){
            System.out.println(iter.next()+",");
        }
        //由后向前输出
        while(iter.hasPrevious()){
            System.out.println(iter.previous()+",");
        }

    }
    /*
    public boolean hasMoreElements()
    public E nextElement()
    vector接口提供取得Enumeration的接口对象
    public Enumeration<E> elements()
     */
    @Test
    public void testEnumeration(){
        Vector<String> all = new Vector<String>();
        all.add("a");
        all.add("b");
        all.add("c");
        Enumeration<String> enu = all.elements();
        while (enu.hasMoreElements()){
            System.out.println(enu.nextElement());
        }

    }

    @Test
    public void testForeach(){
        List<String> all = new ArrayList<String>();
        all.add("a");
        all.add("b");
        all.add("c");
        for(String str:all){
            System.out.println(str);
        }
    }
}
