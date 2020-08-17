import java.util.Arrays;

/*
java.util.Arrays
 */
public class part4_50_Arrays类 {
    public static void main(String[] args) {
        int data [] = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(data));

        int data1 [] = new int[] {1,2,3,4,5};
        System.out.println(Arrays.equals(data,data1));

        //二分查找 返回index
        System.out.println(Arrays.binarySearch(data,4));
     }
}
