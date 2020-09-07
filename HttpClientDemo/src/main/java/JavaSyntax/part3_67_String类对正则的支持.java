package JavaSyntax;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
/*
public boolean matches(String regex)
public String replaceAll(String regex,String replacement)
public String replaceFirst(String regex,String replacement)
public String[] split(String regex)
public String[] split(String regex,int limit)
 */

public class part3_67_String类对正则的支持 {
    @Test
    public void test1(){
        String str = "nkjy98348-fkgljg^**(gndkjhglk";
        String regex = "\\W";
        String regex1 = "[^a-zA-Z]";
        System.out.println(str.replaceAll(regex,""));
        System.out.println(str.replaceAll(regex1,""));

        String str1 = "1234ahgdgfdljg877sfkf907";
        String regex11 = "\\d+";
        System.out.println(str1.replaceAll(regex11,""));
        System.out.println(str1.replaceAll("\\d*",""));
    }
    @Test
    public void test2(){
        //验证某一个字符串是否是数字，如果是转为Double
        String str = "111.111";
        String regex = "\\d+(\\.\\d+)?";//这是一个整体(\\.\\d+)?
        if(str.matches(regex)){
            Double num = Double.parseDouble(str);
            System.out.println(num);
        }
    }
    @Test
    public void test3() throws ParseException {
        //验证一个字符串是否是日期或者日期时间，如果是转换为Date类型
        String str = "2018-01-01 01:01:01";
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        if(str.matches(regex)){
            System.out.println((new SimpleDateFormat("yyyy-MM-dd").parse(str)));
        }else if(str.matches("\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}")){
            System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(str));
        }

    }
    @Test
    public void test4(){
        //判断电话格式是否正确
        //51425222
        //01051425222
        //(010)-51425222
        String str = "(010)-51425222";
        //(   (\\(\\d{3,4}\\)-)?  |  (\\d{3,4})?   )  \\d{7,8}
        String regex = "((\\(\\d{3,4}\\)-)?|(\\d{3,4})?)\\d{7,8}";
        System.out.println(str.matches(regex));
    }
    @Test
    public void test5(){
        //验证email
        String regex = "\\w+@\\w+\\.\\w+";
        //匹配字母 数字 下划线 中划线 点，5-14位
        String regex1 = "[a-zA-Z_-\\.0-9]{5,14}";

    }
}
