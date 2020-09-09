package JavaSyntax;
import java.io.File;
import java.io.IOException;

/*
五个类（File InputStream OutputStream Writer Reader）一个接口(Serializable)
java.io.File
构造方法1：
public File(String pathname)
2：
public File(String parent,String child) 设置父路径和子路径

File类只是创建文件本身，但是对于其内容并不负任何责任

路径问题：
windows使用的是”\“
而UNIX下使用的都是”/“
路径分隔符会采用File类的一个常量来描述：public static final String separator

 */
public class part3_69_File类基本操作 {
    public static void main(String[] args) throws IOException {
//        File file = new File("d:\\MyJava\\hello.txt");
        //由不同的操作系统的JVM来决定最终separator是什么内容
        File file = new File("d:"+ File.separator+"MyJava"+File.separator+"hello.txt");
        //public boolean createNewFile() throws IOException
        //public boolean delete()
        //public boolean exists()
        if(file.exists()){
            file.delete();
        }else {
            file.createNewFile();
        }



    }
}
