package lemon;
class Animal {
    public void eat(){
        System.out.println("animal eat");
    };
    public void sleep(){
        System.out.println("animal sleep");
    };
}
class Cat extends Animal{
    public void catchMouse(){
        System.out.println("cat catches mouse");
    }
    public void eat(){
        System.out.println("cat eat");
    }
}
class Dog extends Animal{
    public void watchDog(){
        System.out.println("dog watches house");
    }
    public void sleep(){
        System.out.println("dog sleep");
    }
}

public class test1 {
    public static void main(String[] args) {
        Animal animal= new Dog();
        Dog dog = (Dog) animal;
        dog.watchDog();
        dog.sleep();
        dog.eat();
    }
}
