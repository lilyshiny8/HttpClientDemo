package JavaSyntax;

import org.testng.annotations.Test;

import java.io.*;

/*
File类不支持文件内容的处理，需要通过流处理。
java.io包中流分为两种：字节流与字符流
区别是字节流是原生的操作，而字符流是经过处理后的操作。在进行网络数据传输，磁盘数据保存支持的数据类型只有字节
而磁盘中的数据必须先读取到内存后才可以操作，内存中会帮助我们将字节变为字符。
字符更加适合处理中文。
字节流
InputStream OutputStream
字符流
Reader Writer
1-根据文件的路径创建File对象
2-根据字节流或字符流的子类实例化父类对象
3-进行数据的读取或写入操作
4-关闭流
对于IO的操作属于资源处理，要关闭
 */
public class part3_73_流操作简介 {
    /*
    public abstract class OutputStream extends Object implements Closeable, Flushable
    将给定的字节数组内容全部输出
    public void write(byte[] b) throws IOException
    将部分的字节数组内容输出
    public void write(byte[] b,int off,int len) throws IOException
    输出单个字节
    public abstract void write(int b) throws IOException

    OutputStream是一个抽象类，要为父类实例化，需要使用子类。因为方法名称已经被父类定义好了，所以我们只是关注子类的构造方法。
    java.lang.Object
        java.io.OutputStream
            java.io.FileOutputStream
    1-接收File类
    public FileOutputStream(File file) throws FileNotFoundException
    2-追加内容
    public FileOutputStream(File file, boolean append) throws FileNotFoundException

     */
    @Test
    public void test1() throws Exception {
        File file = new File("d:"+ File.separator+"MyJava"+File.separator+"hello.txt");
        if(!file.getParentFile().exists()){//必须保证父目录存在
            file.getParentFile().mkdirs();
        }
        //2,OutputStream是一个抽象类，所以必须通过子类进行实例化
        OutputStream output = new FileOutputStream(file,true);//追加模式
        //3，进行文件的输出
        String msg = "www.epam.com\r\n";
        output.write(msg.getBytes());//将内容转为字节数组

        //4，关闭输出
        output.close();

        //没有creatNewFile()的操作。因为在进行文件输出的时候，所有的文件会自动帮助用户创建
        //要换行，加\r\n
        //要部分输出  output.write(msg.getBytes(),0,3)
    }
    /*
    InputStream
    定义：
    public abstract class InputStream extends Object implements Closeable
    方法：
    1-读取数据到字节数组之中
    public int read(byte[] b) throws IOException
        |-返回数据的读取个数
    2-读取部分数据到字节数组中
    public int read(byte[] b, int off, int len) throws IOException
    3-读取单个字节
    public abstract int read() throws IOException

    InputStream是一个抽象类，需要使用FileInputStream类完成
    public class FilterInputStream extends InputStream
     */
    @Test
    public void test2() throws IOException {
        File file = new File("d:"+File.separator+"MyJava"+File.separator+"hello.txt");
        if(file.isFile()){
            InputStream input = new FileInputStream(file);
            byte [] data = new byte[1024];//每次可以读取的最大数量
            int len = input.read(data);//此时的数据读取到数组之宗
            System.out.println("读取内容【"+new String(data,0,len)+"】");
            input.close();

        }

    }
    /*
    public abstract class Writer extends Object implements Appendable, Closeable, Flushable
    方法：
    public void write(String str) throws IOException
    要操作文件使用FileWriter子类

     */
    @Test
    public void test3() throws IOException {
        File file = new File("d:"+File.separator+"MyJava"+File.separator+"hello.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        Writer output = new FileWriter(file);
        String msg = "字符流适合处理中文";
        output.write(msg);
        output.close();
    }
    /*
    public abstract class Reader extends Object implements Readable, Closeable
    子类FileReader
     */
    @Test
    public void test4() throws IOException {
        File file = new File("d:"+File.separator+"MyJava"+File.separator+"hello.txt");
        if(file.exists()){
            Reader in = new FileReader(file);
            char[] data = new char[1024];
            int length = in.read(data);
            System.out.println(new String(data,0,length));
            in.close();

        }
    }
    /*
    字节流和字符流的区别。
    处理中文时使用字符流。
     */
    @Test
    public void test5(){

    }
}
