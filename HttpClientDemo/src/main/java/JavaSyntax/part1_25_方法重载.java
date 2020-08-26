package JavaSyntax;

public class part1_25_方法重载 {
    public static void main(String[] args) {
        double result = add(10,20);
        double result1 = add(10.1, 20.2);
        double result2 = add(10,20,30);
        System.out.println(result+"\n"+result1+"\n"+result2);
    }
    //方法名称相同，参数和参数类型不同。
    //将根据参数的类型或个数的不同执行不同的方法体
    //在进行的方法的重载时有一个重要原则，要求方法的返回类型一定相同
    public static double add( int x, int y) {
        return (double)(x + y) ;
    }
    public static double add (double x, double y) {
        return x + y;
    }
    public static double add (int x, int y, int z) {
        return (double)(x + y +z);
    }
}
