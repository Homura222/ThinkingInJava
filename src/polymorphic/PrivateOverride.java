package polymorphic;

public class PrivateOverride {
    private void f(){
        System.out.println("private");
    }
    public static void main(String[] args){
        PrivateOverride po=new Derived();
        po.f();
    }
}
class Derived extends PrivateOverride{
    public void f(){
        System.out.println("public");
    }
}