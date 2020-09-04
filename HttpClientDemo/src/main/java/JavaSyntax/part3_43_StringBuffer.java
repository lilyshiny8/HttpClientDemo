package JavaSyntax;
/*
All Implemented Interfaces:
Serializable, Appendable, CharSequence

CharSequence 字符集  简单理解为就是一个字符串
 */
public class part3_43_StringBuffer {
    public static void main(String[] args) {
        StringBuffer buf = new StringBuffer();
        buf.append("a");
        System.out.println(buf);

        CharSequence cs = "hello";
        //StringBuffer的一个构造函数
        //public StringBuffer(CharSequence seq)
        //虽然StringBuffer和String都属于CharSequence接口的子类，但这两个类的对象不能直接转换
        //String 转换为StringBuffer
        String str = "hello";
        StringBuffer buff = new StringBuffer();
        buff.append(str);
        //StringBuffer 转为String
        //所有对象都有一个将对象变为String的方法，使用toString()
        buff.toString();

        //public StringBuffer reverse()
//        System.out.println(buff.reverse());

        //public StringBuffer delete(int start,int end)
        System.out.println(buff.delete(1,2));

        //public StringBuffer deleteCharAt(int index)
        System.out.println(buff.deleteCharAt(buff.length()-1));

    }
}
/*
String的内容不可修改，StringBuffer与StringBuilder的内容可修改
StringBuffer采用同步处理，属于线程安全操作，而StringBuilder采用异步处理，属于线程不安全操作。
 */
