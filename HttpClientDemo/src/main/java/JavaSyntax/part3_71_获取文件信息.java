package JavaSyntax;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
判断路径信息
public boolean isDirectory()
public boolean isFile()
文件大小（字节）
public long length()
最后修改日期
public long lastModified()

public File[] listFiles()
 */
class MyMath1 {
    public static double round(double num, int scale){
        return Math.round(num*Math.pow(10,scale))/Math.pow(10,scale);
    }
}
public class part3_71_获取文件信息 {
    public static void main(String[] args) {
        File file = new File("d:"+File.separator+"MyJava"+File.separator+"Filetest"+File.separator+"0803.csv");
        if(file.exists() && file.isFile()){
            double length = MyMath1.round(file.length()/(double)1024,2);
            System.out.println(length);
            String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified()));
            System.out.println(date);
        }
        File file1 = new File("d:"+File.separator);
        if(file1.exists() && file1.isDirectory()){
            File[] list =  file1.listFiles();
            for(File memb:list){
                System.out.println(memb);
            }
        }


    }
}
