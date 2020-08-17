import java.util.Date;

/*
java.util.Date类是整个在程序中唯一可以取得当前日期实例化对象的操作方法，
Date类对象
 */
public class part4_47_Date类 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        //public Date(long date)
        Date d1 = new Date(12345678L);
        System.out.println(d1);

        //public long getTime()
        System.out.println(date.getTime());
    }
}
