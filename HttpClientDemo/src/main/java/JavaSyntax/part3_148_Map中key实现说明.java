package JavaSyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
用户自定义key
一定要覆写hashCode()和equals()
 */
class Person148{
    private String name;
    public Person148(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person148{" +
                "name='" + name + '\'' +
                '}';
    }
//不覆写hashCode()和equals()，返回的是null。因为要通过hashCode确定唯一性
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person148 person148 = (Person148) o;
        return Objects.equals(name, person148.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
public class part3_148_Map中key实现说明 {
    public static void main(String[] args) {
        Map<Person148,String> map = new HashMap<Person148,String>();
        map.put(new Person148("tony"),"lily");
        System.out.println(map.get(new Person148("tony")));//不覆写hashCode()和equals()，返回的是null
    }
}
