package JavaSyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*

 */
class Person133{
    private String name;
    private Integer age;//Integer与int的区别在于，Integer可以为null
    public Person133(String name,Integer age){
        this.name = name;
        this.age = age;
    }
    //对于集合中的remove(),contains()方法必须类中有equals()的支持
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person133 person133 = (Person133) o;
        return Objects.equals(name, person133.name) &&
                Objects.equals(age, person133.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    @Override
    public String toString() {
        return "Person133{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class part3_133_List与简单java类 {
    public static void main(String[] args) {
        List<Person133> all = new ArrayList<Person133>();
        all.add(new Person133("name1",1));
        all.add(new Person133("name2",2));
        all.add(new Person133("name3",3));

        //对于集合中的remove(),contains()方法必须类中有equals()的支持****************************
        all.remove(new Person133("name2",2));

        for(int x = 0;x< all.size();x++){
            System.out.println(all.get(x));//上边覆写了toString的方法
        }

    }
}
