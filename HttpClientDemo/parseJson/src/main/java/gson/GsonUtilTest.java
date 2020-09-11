package gson;

import org.junit.Assert;

import org.testng.annotations.Test;
import util.GsonUtil;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GsonUtilTest {

    @Test
    public void constructionTest() {
        GsonUtil gsonUtil = new GsonUtil();
    }

    @Test
    public void gsonString() {
        String str = GsonUtil.GsonString(new Object());
        Assert.assertEquals("{}", str);

        String listString = GsonUtil.GsonString(Collections.singletonList("Item"));
        Assert.assertEquals("[\"Item\"]", listString);

        String mapString = GsonUtil.GsonString(Collections.singletonMap("Key", "Value"));
        Assert.assertEquals("{\"Key\":\"Value\"}", mapString);

    }

    @Test
    public void gsonToList() {
        String listString = "[\"Item\"]";
        List<String> list = GsonUtil.GsonToList(listString, String.class);

        Assert.assertEquals(1, list.size());
        Assert.assertEquals("Item", list.get(0));

//        List<Object> nullList = GsonUtil.GsonToList(null, Object.class);
//        Assert.assertNull(nullList);
    }

    @Test
    public void gsonToMaps() {
        String mapString = "{\"Key\":\"Value\"}";
        Map<String, String> map = GsonUtil.GsonToMaps(mapString);

        Assert.assertEquals(1, map.size());
        Assert.assertEquals("Value", map.get("Key"));

//        Map nullMap = GsonUtil.GsonToMaps(null);
//        Assert.assertNull(nullMap);
    }

    @Test
    public void gsonToListMaps() {
        List<Map<String, String>> mapList = Collections.singletonList(Collections.singletonMap("Key","Value"));
        String str = GsonUtil.GsonString(mapList);
        System.out.println(str);
        String s = "[{\"Key\":\"Value\"}]";

        List<Map<String, String>> mapListConverted = GsonUtil.GsonToListMaps(s);
        Assert.assertEquals(1, mapListConverted.size());
        Map<String, String> map = mapListConverted.get(0);
        Assert.assertEquals(1, map.size());
        Assert.assertEquals("Value", map.get("Key"));

//        List nullList = GsonUtil.GsonToListMaps(null);
//        Assert.assertNull(nullList);
    }

    @Test
    public void gsonToBean() {
        //ms will be truncated during  GsonString
        Date sysdate = new Date(System.currentTimeMillis() /  1000L * 1000L);
        String dateString = GsonUtil.GsonString(sysdate);
        System.out.println(dateString);

        Date dateConverted = GsonUtil.GsonToBean(dateString, Date.class);
        Assert.assertEquals(sysdate, dateConverted);
    }
}
