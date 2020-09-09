package JavaSyntax;

import java.io.File;
import java.io.IOException;

/*
获得父路径：public File getParentFile()
因为我们需要进行父目录的创建，所以最好取得父路径的File类对象
创建目录
public boolean mkdirs()


 */
public class part3_70_创建目录 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:"+File.separator+"MyJava"+File.separator+"Filetest"+File.separator+"hello.txt");
        //如果有多级目录要先创建目录再创建文件
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();//创建多级
        }
        if(file.exists()){
            file.delete();
        }else{
            file.createNewFile();
        }

    }
}
