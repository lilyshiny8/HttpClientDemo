package JavaSyntax;
/*
=======
package JavaSyntax;/*
>>>>>>> parse json
java.text
SimpleDateFormat

类的继承
java.lang.Object
java.text.Format
java.text.DateFormat
java.text.SimpleDateFormat

实现日期的格式化处理，格式化之后是字符串
年（yyyy）月（MM）日（dd）时（HH）分（mm）秒（ss）毫秒（SSS）
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class part3_48_SimpleDateFormat {
    public static void main(String[] args) throws Exception {
        //实现日期的格式化处理，格式化之后是字符串
        String pat = "yyyy-MM-dd HH:mm:ss:SSS";
        Date date = new Date();//当前的日期时间
        SimpleDateFormat sdf = new SimpleDateFormat(pat);
        String val = sdf.format(date);
        System.out.println(val);

        //字符串转日期
        String str1 = "2020-08-06 21:50:14:735";
        SimpleDateFormat sdf1 = new SimpleDateFormat(pat);
        Date date1 = sdf1.parse(str1);
        System.out.println(date1);




    }
}
