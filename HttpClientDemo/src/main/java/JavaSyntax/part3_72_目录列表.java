package JavaSyntax;
/*
File类中的listFiles()方法只能列出第一级目录，如果要列出所有子级
 */

import java.io.File;

public class part3_72_目录列表 {
    public static void main(String[] args) {
//        File file = new File("d:"+File.separator);
//        listDir(file);
        //列出的操作不完成，对于后续的执行将无法完成，这种耗时的操作，让我们的主线程出现阻塞，导致后面的代码无法执行完毕
        //改为
        new Thread(()->{
            File file = new File("d:"+File.separator);
            listDir(file);
        },"列出线程").start();
        System.out.println("开始进行文件的信息列出........");

    }
    public static void listDir(File file){
        if(file.isDirectory()){
            File[] result  = file.listFiles();
            if(result != null) {
                for(int x =0;x<result.length;x++){
                    listDir(result[x]);
                }
            }

        }
        System.out.println(file);
    }
}
