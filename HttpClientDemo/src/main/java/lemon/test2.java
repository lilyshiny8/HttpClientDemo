package lemon;
class Employee{
    public void work(){
        System.out.println("employee work");
    };
    public void sleep(){
        System.out.println("employee sleep");
    };
}
class Coder extends Employee{
    public void work(){
        System.out.println("coder work");
    }
    public void sleep(){
        System.out.println("coder sleep");
    }
}
class Tester extends Employee{
    public void work(){
        System.out.println("tester work");
    }
    public void sleep(){
        System.out.println("tester sleep");
    }
}
class Manager extends Employee{
    public void work(){
        System.out.println("manager work");
    }
    public void sleep(){
        System.out.println("manager sleep");
    }
}
public class test2 {
    public static void main(String[] args) {
        Employee employee = new Coder();
        employee.work();
        employee.sleep();
        Employee employee1 = new Tester();
        employee1.work();
        employee1.sleep();
        Employee employee2 = new Manager();
        employee2.work();
        employee2.sleep();

        fun(new Coder());
    }
    public static void fun(Employee employee){
        employee.work();
        employee.sleep();
    }
}
