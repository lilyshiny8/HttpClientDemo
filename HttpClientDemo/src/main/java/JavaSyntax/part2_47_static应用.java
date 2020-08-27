package JavaSyntax;

public class part2_47_static应用 {
    public static void main(String[] args) {
        new Person47().print();
        new Person47("tony").print();
        System.out.println(new Person47().toString());
    }
}
class Person47{
    private String name;
    private static int count = 0 ;
    //使用this(参数)调用下面的有参构造函数，如果用户不传入名称，则为用户自动生成一个名称
    public Person47(){
        this("NoName_"+count++);

    }
    public Person47(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void print(){
        System.out.println(getName());
    }
    public String toString(){
        return "name = "+ this.name;
    }
}
