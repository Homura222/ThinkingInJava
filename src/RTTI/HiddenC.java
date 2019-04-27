package RTTI;

class C implements A {

    @Override
    public void f() {
        System.out.println("C.f");
    }

    public void g() {
        System.out.println("c.g");
    }

    void u() {
        System.out.println("c.u()");
    }

    protected void v() {
        System.out.println("C.v");
    }

    private void w() {
        System.out.println("c.w");
    }
}

public class HiddenC {
    public static A makeA(){
        return new C();
    }
}
