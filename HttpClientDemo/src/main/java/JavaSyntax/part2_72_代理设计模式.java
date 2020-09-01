package JavaSyntax;
/*
两个子类共同实现一个接口，其中一个子类负责真实的业务实现，而另外的子类负责辅助真实业务主题的操作
 */
//一个接口
interface ISubject{
    public void save();
}
//两个子类-1
class RealSubject implements ISubject{
    public void save(){
        System.out.println("RealSubject save");
    }
}
//两个子类-2
class ProxySubject implements ISubject{//代理实现
    private ISubject subject;
    //在创建代理类对象的时候必须设置要代理的真实主题
    public ProxySubject(ISubject subject){
        this.subject = subject;
    }
    public void broke(){
        System.out.println("open the door");
    }
    public void award(){
        System.out.println("award");
    }
    public void save(){//接口子类一定要实现抽象方法
        this.broke();//1-真实操作前的准备
        subject.save();//2-调用真实的业务
        this.award();//3-操作后的收尾

    }
}
class Factory1 {
    public static ISubject getInstance() {
        return new ProxySubject(new RealSubject());
    }
}
public class part2_72_代理设计模式 {
    public static void main(String[] args) {
//        ISubject sub = new ProxySubject(new RealSubject());
        ISubject sub = Factory1.getInstance();
        //通过代理类对象发出，利用代理类来实现真实业务调用
        sub.save();
    }
}
