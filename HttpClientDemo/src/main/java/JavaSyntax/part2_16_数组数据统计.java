package JavaSyntax;

//在整个程序开发中，主方法不要涉及过过于复杂的程序逻辑,只需要关注结果
public class part2_16_数组数据统计 {
    public static void main(String[] args) {
        int arr[] = new int[] {1,2,3,4,66,7,8};
        double result[] = statis(arr);
        System.out.println((int)result[0]+"\n"+result[1]+"\n"+result[2]+"\n"+result[3]);


    }
    public static double[] statis(int arr[]) {
        double resArr[] = new double[4];
        resArr[0] = arr[0];//max
        resArr[1] = arr[0];//min
        resArr[2] = arr[0];//sum
        resArr[3] = arr[0];//avg
        for (int x=1; x<arr.length; x++) {
            if(arr[x] > resArr[0]) {
                resArr[0] = arr[x];
            }
            if(arr[x] < resArr[1]) {
                resArr[1] = arr[x];
            }
            resArr[2] = resArr[2] + arr[x];
        }
        resArr[3] = resArr[2] / arr.length;
       return resArr;


    }
}
