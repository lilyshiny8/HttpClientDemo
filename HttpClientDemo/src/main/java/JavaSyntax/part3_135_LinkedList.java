package JavaSyntax;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
*******************ArrayList的核心代码
无参构造，可以发现ArrayList里面存放的是要给数组
public ArrayList() {this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;}
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
有参构造。如果在实例化此类对象的时候默认传入了数组的大小，则里面保存的数组就会开辟一个定长的数组。但是如果后面再进行数据保存的时候发现数组的个数不够了，那么会进行数组的动态扩充。
所以很明显再实际的开发之中，如果要使用ArrayList最好的做法就是设置初始化的大小
public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        }
    }



**********************LinkedList
是一个纯粹的链表实现。

总结：ArrayList封装的是一个数组，LinkedList封装的是一个链表实现。ArrayList的查找元素的时间复杂度为1，LinkedList的时间复杂度为n。
 */
public class part3_135_LinkedList {
    public static void main(String[] args) {
        List<String> all = new LinkedList<String>();
        all.add("A");
        all.add("B");
        all.remove("A");
        System.out.println(all);

        LinkedList<String> all1 = new LinkedList<String>();
        all1.add("AA");
        System.out.println(all1);
    }
}
