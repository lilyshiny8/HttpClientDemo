/*
方法1：
开辟一个新的数组，将原始数组倒序放进去
disadvantage 开辟了两个相同的堆内存空间 arr temp  空间复杂度高
空间占的是内存（空间复杂度），时间占的是cpu（时间复杂度）
方法2：
数组原地转置
 */
public class part2_18_数组案例_数组转置 {
    public static void main(String[] args) {
        int arr [] = new int[]{1,2,3,4,5,6,7,8,9};
        int[] result = reverse(arr);
        reverse1(arr);
        int arr1[][] = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        reverse2(arr1);
        printArr(arr1);

    }
    //方法1
    public static int[] reverse(int arr[]) {
        int temp [] = new int[arr.length];
        int foot = 0;
        for (int x=arr.length-1; x>=0; x-- ) {
            temp[foot] = arr[x];
            foot++;
        }
        return temp;
    }
    //方法2
    public static void reverse1(int arr[]) {
        int center = arr.length / 2;
        int head = 0;
        int tail = arr.length - 1;
        for (int x=0; x<center; x++) {
            int temp = arr[head];
            arr[head] = arr[tail];
            arr[tail] = temp;
            head++;
            tail--;
        }
    }
    //二维数组转置
    public static void reverse2(int arr[][]) {
        for (int x=0; x<arr.length; x++) {
            for (int y=x; y<arr[x].length; y++) {
                if(x!=y){
                    int temp = arr[x][y];
                    arr[x][y] = arr[y][x];
                    arr[y][x] = temp;
                }
            }
        }
    }
    public static void printArr(int arr[]) {
        for (int x = 0; x < arr.length; x++) {
            System.out.println(arr[x]);
        }
    }
    public static void printArr(int arr[][]) {
        for (int x = 0; x < arr.length; x++) {
            for (int y=0; y<arr[x].length; y++) {
                System.out.print(arr[x][y]+",");
            }
            System.out.println();
        }
    }
}
