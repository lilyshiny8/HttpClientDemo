package JavaSyntax;

/*
同一块堆内存空间可以被不同的栈内存所指向

 */
public class part2_11_数组引用传递 {
    public static void main(String[] args) {
        int arr2 [] = new int[3];
        int temp [] = null;
        arr2[0] = 1;
        temp = arr2;//[] 是在定义和使用时出现的，如果要发生引用传递，不要出现[]//temp指向了arr2的堆内存空间
        temp[0] = 111;
        for (int x=0; x < arr2.length; x++){
            System.out.println(arr2[x]);
        }
    }

}

