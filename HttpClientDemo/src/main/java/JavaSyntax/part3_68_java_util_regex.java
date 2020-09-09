package JavaSyntax;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
取得实例化对象：public static Pattern compile(String regex)
拆分字符串：public String[] split(CharSequence input)
取得Matcher类对象：public Matcher matcher(CharSequence input)
 */
public class part3_68_java_util_regex {
    @Test
    public void test1(){
        String str = "a|b|c";
        String regex = "\\|";
        Pattern pat = Pattern.compile(regex);
        String [] result = pat.split(str);
        for(String ele:result){
            System.out.println(ele);
        }
    }
    //Matcher负责正则匹配
    /*
    public boolean matches()
    public String replaceAll(String replacement)
     */
    @Test
    public void test2(){
        String str = "INSERT INTO member(mid,name,age) VALUES (#{member.mid},#{member.name},#{member.age})";
        //+ one or more times
        String regex = "#\\{[a-zA-Z_0-9\\.]+\\}";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(str);
        while(mat.find()){//依次进行比较，如果符合则取出内容
            System.out.println(mat.group());
        }


    }
}
