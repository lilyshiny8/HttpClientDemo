package JavaSyntax;

class Array1{
    private int [] data;
//    public int num;
    private int foot=0;
//    public int member;

    public Array1(int num){

        if (num>0){
            data = new int [num];
        }else {
            data = new int[0];}
    }
    public boolean add(int member){

        if(foot<data.length){
            data[foot]=member;
            foot++;
            return true;
        }
        return false;
    }
    //改变数组长度，新建一个数组，将原数组中的数据拷贝到新数组
    public int[] inc(int incNum){
        if(foot>=data.length){
            int[] newData = new int [incNum+data.length];
            System.arraycopy(this.data,0,newData,0,data.length);
            //***********************改变原始数组指向****************************
            this.data = newData;

        }
        return new int[0];
    }
}

public class part2_60_定义Array父类_1 {
    public static void main(String[] args) {
        Array1 array = new Array1(3);
        System.out.println(array.add(1));
        System.out.println(array.add(2));
        System.out.println(array.add(3));
        array.inc(3);
        System.out.println(array.add(4));
        System.out.println(array.add(5));
        System.out.println(array.add(6));
        System.out.println(array.add(7));
        System.out.println(array);

    }
}
