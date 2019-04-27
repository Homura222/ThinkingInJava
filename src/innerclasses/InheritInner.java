package innerclasses;

class WithInner{
    class Inner{}
}

public class InheritInner extends WithInner.Inner{
    //用空构造器无法通过编译
    public InheritInner(WithInner wi) {
        wi.super();
    }
    public static void main(String[] args){
        WithInner wi=new WithInner();
        InheritInner ii=new InheritInner(wi);
    }
}
