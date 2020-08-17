package JavaSyntax;

public class part1_11_TypeFloat {
    public static void main(String[] args) {
        //常量默认是double类型//float f1 = 1.1; 所以这样报错
        float f1 = 1.1f;
        float f2 = 1.1F;
        float f3 = (float) 1.1;

        //
        int numA = 10;
        int numB = 4 ;
        // int 除以 int 还是int类型
        System.out.println(numA / numB);
        // 所以要将其中一个转为浮点型
        System.out.println((double)numA / numB);



    }
}
