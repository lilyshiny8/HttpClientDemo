/*
数组的动态初始化：
数据类型 对象数组 [][] = new 数据类型[行个数][列个数]
数组的静态初始化
数据类型 对象数据 [][] = new 数据类型[][] {
{val,val,....},{val,val,....},{val,val,....}}
 */
public class part2_13_二维数组 {
    public static void main(String[] args) {
        int arr3 [][] = new int[][] {
                {1,1},{2,2,2,2},{3,3,3}
        };
        for (int x = 0;x<arr3.length;x++) {//行数
            for (int y=0;y<arr3[x].length;y++) {//列数
                System.out.print(arr3[x][y]);
            }
        }

    }
}
