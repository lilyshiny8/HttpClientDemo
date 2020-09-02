package JavaSyntax;

class Array{
    private int [] data;
    public int num;
    private int foot=0;
    public int member;

    public Array(int num){
        this.num = num;
        if (this.num>0){
            data = new int [this.num];
        }else {
            data = new int[0];}
    }
    public boolean add(int member){
        this.member=member;
        if(this.foot<this.data.length){
            data[this.foot]=this.member;
            this.foot++;
            return true;
        }
        return false;
    }
    //改变数组长度，新建一个数组，将原数组中的数据拷贝到新数组
    public int[] inc(int incNum){
        if(this.foot>=this.num){
            int[] newData = new int [incNum+this.num];
            System.arraycopy(this.data,0,newData,0,this.num);
            //改变原始数组指向****************************
            this.data = newData;

        }
        return new int[0];
    }
}
public class part2_60_定义Array父类 {
    public static void main(String[] args) {
        Array array = new Array(3);
        System.out.println(array.add(1));
        System.out.println(array.add(2));
        System.out.println(array.add(3));
        array.inc(3);
        System.out.println(array.add(4));

    }
}
