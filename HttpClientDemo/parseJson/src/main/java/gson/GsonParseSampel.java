package gson;

import Bean.Person;
import Bean.PersonWithCollection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;


public class GsonParseSampel {
    public static void main(String[] args) throws IOException {
        File file = new File(GsonParseSampel.class.getResource("/tony.json").getFile());
        String content = FileUtils.readFileToString(file);
        Gson gs = new Gson();


        //bean与json文件对应，进行反解析
        Person tony = gs.fromJson(content,Person.class);
        System.out.println(tony.getIgnore());
        System.out.println(tony.getAge());
        System.out.println(tony.getCar());


        //处理日期
        Gson gs1 = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Person tony1 = gs1.fromJson(content,Person.class);
        System.out.println(tony1.getBirthday().toLocaleString());

        //集合类解析
        Gson gs2 = new Gson();
        PersonWithCollection tony2 = gs2.fromJson(content,PersonWithCollection.class);
        System.out.println(tony2.getMajor());
        System.out.println(tony2.getMajor().getClass());



    }
}
