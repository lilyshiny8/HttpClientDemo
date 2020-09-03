package JavaSyntax;
/*
类集实际上就属于动态的对象数组
java.util，类集中提供两个最为核心的操作接口，collection,Map
每一次进行数据操作的时候只能够对单个对象进行处理，所以Collection是单个集合保存的最大父接口。
Collection接口定义
public interface Collection<E> extends Iterable<E>
Iterator<T> iterator()

常用方法：
public boolean add(E e)
public boolean addAll(Collection<? extends E> c)//向集合中添加一组数据
public void clear()
public boolean contains(Object o)
public boolean isEmpty() //需要使用equals()方法
public boolean remove(Object o) //需要使用equals()方法
public int size()
public Object[] toArray() //将集合变为对象数组返回
public Iterator<E> iterator() //取得Iterator接口对象，用于输出

***add和Iterator

Collection接口的两个子接口：List(允许重复),Set(不允许重复)
 */

public class part3_129_Java类集 {
}
