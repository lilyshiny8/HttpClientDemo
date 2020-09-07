package JavaSyntax;
enum Color{
    red,brown,black;//如果定义很多内容，枚举对象必须写在第一行
    //在枚举中定义属性，方法，接口
    private String titile;
    private Color(){};
    private Color(String title){//构造方法绝对不能够使用public
        this.titile=title;
    }
    public String toString(){//覆写Object类中的方法
        return this.titile;
    }

}
public class part3_14_多例与枚举 {
    public static void main(String[] args) {
        //values()返回一个数组
        for(Color temp:Color.values()){
            System.out.println(temp.ordinal()+"="+temp.name());
        }

        System.out.println(Color.red);
    }
}
