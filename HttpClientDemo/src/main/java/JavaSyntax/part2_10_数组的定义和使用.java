public class part2_10_数组的定义和使用 {
    public static void main(String[] args) {
        int arr1 [] = new int [3];
        int [] arr2 = new int [3];

        int arr3 [] = null;
        arr3 = new int [3];
        //array.length  没有括号是属性不是方法
        for(int x=0;x<arr1.length;x++){
            System.out.println(arr1[x]);
        }
    }
}
