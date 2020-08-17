package JavaSyntax;

public class part2_7_private实现封装处理 {
    //类中的所有属性必须使用private封装。而使用private封装的属性如果需要被外部所使用，那就按照格式定义相应的setter、getter方法
    //private实现封装的最大特征，只允许本类访问，不允许外部访问
    //private只是封装的第一步

    //private实现封装处理
    //一旦属性的声明上有private，其他类就不能直接访问该属性
    public static void main(String[] args) {
        Per person1 = new Per();
        //private属性的name不能被操作  person1.name = "a";
        /*对private属性的访问，可以使用setter getter
        |-setter方法：主要用于进行属性内容的设置；
        private String name: public void setName(String n);
        |-getter方法：主要用于属性内容的取得；
        private String name: public void getName(String n);
         */

        person1.setName("AAA");
        person1.setAge(3);
//        person1.getName();
//        person1.getAge();
        person1.info();

    }
}

class Per {
    //实现对private属性的访问
    private String name;
    private int age;

    public void setName(String n) {
        name = n;
    }
    public void setAge(int m) {
        age = m;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void info() {
        System.out.println("name = " + name + ", age = "+age);
    }
}
