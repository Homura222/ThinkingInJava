package RTTI;

class B implements A {

    @Override
    public void f() {

    }

    public void g() {
        System.out.println("B.g()");
    }
}

public class InterfaceViolation {
    public static void main(String[] args) {
        //使用接口向上转型后，a的类型信息依然是B
        A a = new B();
        a.f();
        System.out.println(a.getClass().getName());
        //即如果实际类型是子类型，依然可以转型后调子类型，导致出现你不想要出现的耦合
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
}
