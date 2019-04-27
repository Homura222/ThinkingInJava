package innerclasses.factory;

class Implementationl implements Service{
    private Implementationl() {
    }
    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }
    @Override
    public void method2() {
        System.out.println("Implementation1 method2");
    }
    public static ServiceFactory factory=new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementationl();
        }
    };
}

class Impletementation2 implements Service{

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }
    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }
    public static ServiceFactory factory=new ServiceFactory() {
        @Override
        public Service getService() {
            return new Impletementation2();
        }
    };
}
public class Factories {
    public static void serviceConsumer(ServiceFactory factory){
        Service s=factory.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args){
        serviceConsumer(Implementationl.factory);
        serviceConsumer(Impletementation2.factory);
    }
}
