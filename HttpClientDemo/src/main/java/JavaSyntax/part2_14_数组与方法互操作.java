/*
数组是一个引用数据类型，所有引用数据类型都可以为其设置多个栈内存指向。数组也可以通过方法进行处理。
 */
public class part2_14_数组与方法互操作 {
    public static void main(String[] args) {
        int arr4[] = init();
        inc(arr4);
        printArray(arr4);//引用传递，temp指向了与arr4相同的同一个堆内存空间

    }
    public static int[] init() {
        return new int[] {1,2,3,4};//匿名数组
    }
    public static void printArray(int temp[]) {
        for (int x=0; x<temp.length; x++) {
            System.out.println(temp[x]);
        }
    }
    public static void inc(int arr[]) {
        for(int x=0; x<arr.length; x++) {
            arr[x] = arr[x]*2;
        }
    }
}
