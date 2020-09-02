package JavaSyntax;
//可以接收所有的引用数据类型，包括数组，接口
//Object真正达到了参数的统一，如果一个类想要接收所有的数据类型，就使用Object完成。

//接口
interface IMessage_1 {

}
class MessageImpl_1 implements IMessage_1 {
    public String toString() {
        return "www.mldn.cn";
    }
}

public class part2_78_Object类_接收引用数据类型 {
    public static void main(String[] args) {
        //数组
        //利用Object接收数组对象，向上转型
        Object obj = new int[] {1,2,3};
        //向下转型，需要强制类型
        int data [] = (int[])obj;

        //Object可以接收接口更是Java中的强制性要求，因为接口本身是不可能继承任何类的
        //接口
        IMessage_1 msg = new MessageImpl_1();//子类向父接口转型
        Object obj1 = msg;//接口向Object转型
        System.out.println(obj1);
        IMessage_1 temp = (IMessage_1) obj1;//强制转换

    }
}
