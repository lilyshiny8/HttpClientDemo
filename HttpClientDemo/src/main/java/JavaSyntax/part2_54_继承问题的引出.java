package JavaSyntax;

/*
子类-派生类
父类-超类-Super Class
当发生类继承关系后，子类可以直接继承父类的操作，可以实现代码的重用，子类最低也维持和父类相同的功能
继承可以进行父类功能的扩充。可以重用父类中的方法。
 */

class Person54{

    private String name;
    private int age;
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
}
class Student extends Person54{
    private String school;
    public void setSchool(String school){
        this.school=school;
    }
    public String getSchool() {
        return this.school;
    }
    public void print(){

    }

}
public class part2_54_继承问题的引出 {
    public static void main(String[] args) {
        Student st = new Student();
        st.setName("tony");
        st.setAge(11);
        st.setSchool("abc");
        System.out.println(st.getName()+","+st.getAge()+","+st.getSchool());
    }
}
