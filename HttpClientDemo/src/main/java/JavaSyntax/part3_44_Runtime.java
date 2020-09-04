package JavaSyntax;

/*
构造方法私有化
因为其只能有一个实例化对象，所以该类使用的是单例设计模式
单例设计模式一定会在类的内部提供有一个取得对象的方式


gc()
garbage collector  用于释放无用的内存空间
一种是自动不定期调用
一种是调用Runtime类中的gc方法，手工调用
 */
public class part3_44_Runtime {
    public static void main(String[] args) {
        //public static Runtime getRuntime() 静态方法
        Runtime t = Runtime.getRuntime();
        System.out.println(t.toString());

        //public long freeMemory()
        System.out.println(t.freeMemory());

        //public long totalMemory()
        System.out.println(t.totalMemory());

        System.out.println(t.maxMemory());

        //public void gc()
        t.gc();
    }
}
