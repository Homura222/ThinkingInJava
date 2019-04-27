package generics;

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends SelfBounded<A> {}
class B extends SelfBounded<A>{}

class C extends SelfBounded<C>{
    C setAndGet(C arg){
        set(arg);
        return get();
    }
}


public class SelfBounding {
    public static void main(String[] args){
        //能检测出类型
        A a=new A();
        a.set(new A());
//        System.out.println(a.get().getClass().getSimpleName());
        a=a.set(new A()).get();
        System.out.println(a.getClass().getSimpleName());

        C c=new C();
        c=c.setAndGet(new C());
        System.out.println(c.getClass().getSimpleName());
    }
}
