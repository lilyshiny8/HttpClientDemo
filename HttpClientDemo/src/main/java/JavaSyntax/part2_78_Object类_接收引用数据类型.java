package JavaSyntax;

import java.awt.image.ImageConsumer;

//接口
interface IMessage {

}
class MessageImpl implements IMessage {
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

        //接口
        IMessage msg = new MessageImpl();//子类向父接口转型
        Object obj1 = msg;//接口向Object转型
        System.out.println(obj1);
        IMessage temp = (IMessage) obj1;//强制转换

    }
}
