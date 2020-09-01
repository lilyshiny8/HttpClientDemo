package JavaSyntax;

import javax.swing.plaf.IconUIResource;

/*
三大核心应用
1-定义操作标准
2-表示能力
3-在分布式开发之后暴露远程服务方法

使用接口和对象多态性的概念结合之后，对于参数的统一更加明确了。而且接口是在类之上的设计抽象。
先设计接口再写类
 */
interface USB{
    public void setup();
    public void work();
}
class Computer{
    public void plugin(USB usb){
        usb.setup();
        usb.work();
    }
}
class Flash implements USB{
    public void setup(){
        System.out.println("Flash setup");
    }
    public void work(){
        System.out.println("Flash work");
    }
}
public class part2_70_使用接口定义标准 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.plugin(new Flash());
    }
}
