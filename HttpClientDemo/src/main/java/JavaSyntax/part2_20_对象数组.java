/*
基本数据类型数组
对象数组
对象数组动态初始化：
类名称 对象数组名称 [] = new 类名称 [长度];
对象数组静态初始化
类名称 对象数组名称 [] = new 类名称 [长度] {实例化对象，实例化对象...};
 */
class Person {
    private String name;
    private int age;
    public void setName(String n){
        name = n;
    }
    public void setAge(int a) {
        age = a;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public Person(String n ,int a) {
        setName(n);
        setAge(a);
    }
    public String getInfo() {
        return "name = "+ name +", age = " + age;
    }
}
public class part2_20_对象数组 {
    public static void main(String[] args) {
        //动态初始化
        Person perArr [] = new Person[3];
        perArr[0] = new Person("A",1);
        perArr[1] = new Person("B",2);
        perArr[2] = new Person("C",3);
        for (int x = 0; x<perArr.length; x++) {
            System.out.println(perArr[x].getInfo());
        }

        //静态初始化
        Person perArr1 [] = new Person[] {
                new Person("AA",11),
                new Person("BB",22),
                new Person("CC",33)
        };
        for (int x = 0; x<perArr1.length; x++) {
            System.out.println(perArr1[x].getInfo());
        }

    }

}
