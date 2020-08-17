/*
冒泡排序
 */
public class part2_17_数组案例_数组排序 {
    public static void main(String[] args) {
        int arr [] = new int[] {3,2,6,7,4,5,9,0,1} ;
        sort(arr);
        printArr(arr);

    }
    public static void sort(int arr[]) {
        for (int x=0; x< arr.length-1; x++) {
            for (int y=0; y<arr.length-1-x; y++) {
                if (arr[y] > arr[y+1]) {
                    int temp = arr[y];
                    arr[y] = arr[y+1];
                    arr[y+1] = temp;
                }
            }
        }
    }
    public static void printArr(int arr[]) {
        for (int x = 0; x < arr.length; x++) {
            System.out.println(arr[x]);
        }
    }
}
