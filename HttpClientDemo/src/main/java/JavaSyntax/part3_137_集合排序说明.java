package JavaSyntax;
import java.util.Objects;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;
/*
Set  重复元素的过滤。注意需要依靠hashCode() equlas()两个方法
 */
class Person137 {
    private String name;
    private int age;

    public Person137(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person137{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person137 person137 = (Person137) o;
        return age == person137.age &&
                Objects.equals(name, person137.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
public class part3_137_集合排序说明 {
    public static void main(String[] args) {
        /*
        Set<Person137> set= new TreeSet<Person137>();
        JavaSyntax.Person137 cannot be cast to java.lang.Comparable
         */

        /*
        HashSet进行重复元素判断依靠是的Object类的两个方法
        hash码：public int hashCode()
        对象比较：public boolean equals(Object obj)
         */
        Set<Person137> set= new HashSet<Person137>();
        set.add(new Person137("A",1));
        set.add(new Person137("A",1));
        set.add(new Person137("B",1));
        set.add(new Person137("B",2));
        set.add(new Person137("C",3));
        System.out.println(set);

    }
}

