
import org.testng.annotations.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
public class test {
    public static Logger logger = Logger.getLogger(test.class.getName());
    @Test
    public void test1() {
        String var1 = "123";
        System.out.println(var1.equals("123"));
        System.out.println(var1=="123");
    }
    @Test
    public void test2()
    {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("name", "孙笑川");
        map.put("age", 25);
        map.put("height", 1.70);
        map.put("major", new String[] { "理发", "挖掘机" });
        map.put("hasGirlFriend", false);
        map.put("car", null);
        map.put("house", null);

        //null作为value时，转换成json后不会保存
        JSONObject json1 = new JSONObject(map);
        System.out.println(json1.toString());

    }
    @Test
    public void test3()
    {
        JSONObject json3 = new JSONObject();


        json3.put("major", new String[] { "理发", "挖掘机" });
        json3.put("changeTimes", 72);
        json3.put("name", "MonkeySun"); //put方法：value保留原格式，若key相等，value会覆盖原值
        json3.put("isHuman", false);
        json3.append("nickName", "齐天大圣"); //append方法：value存放在数组中，若key相等，value会覆盖原值
        json3.append("nickName", "弼马温");
        json3.accumulate("Teacher", "元始天尊"); //accmulate方法,和append方法一样
        json3.accumulate("Teacher", "唐三藏");
        System.out.println(json3.toString());
    }
    @Test
    public void test4(){
        String testcasepath=System.getProperty("user.dir")+ File.separator+"data"+File.separator+"testcase"+File.separator;
        System.out.println(testcasepath);
    }
    @Test
    public void test5(){
        logger.severe("严重");
        logger.warning("警告");
        logger.info("信息");
        logger.config("配置");
        logger.fine("良好");
        logger.finer("较好");
        logger.finest("最好");
    }
}
