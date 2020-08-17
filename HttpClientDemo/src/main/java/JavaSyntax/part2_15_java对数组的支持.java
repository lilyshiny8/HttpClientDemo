public class part2_15_java对数组的支持 {
    public static void main(String[] args) {
        int intArr[] = new int[] {5,8,3,6};
        char charArr[] = new char[] {'a','z','b'};
        //数组排序
        java.util.Arrays.sort(intArr);
        java.util.Arrays.sort(charArr);
//        printArr(intArr);
//        printArr(charArr);
        //数组拷贝
        //System.arraycopy(源数组名称，源数组开始点，目标数组名称，目标数组开始点，拷贝长度);
        int sourceArr[] = new int[] {1,2,3,4,5};
        int distantArr[] = new int[] {11,22,33,44,55};
        System.arraycopy(sourceArr,1,distantArr,2,2);
        printArr(distantArr);

    }
    public static void printArr(int arr[]) {
        for (int x=0; x<arr.length; x++) {
            System.out.println(arr[x]);
        }
    }
    public static void printArr(char arr[]) {
        for (int x=0; x<arr.length; x++) {
            System.out.println(arr[x]);
        }
    }
}