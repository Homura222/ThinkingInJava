package RTTI;

import java.util.Random;

class Initable{
    static final int staticFinal=47;
    static final int staticFinal2=ClassInitialization.random.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2{
    static int staticNonFinal=147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initiable3{
    static int staiticNonFinal=74;
    static {
        System.out.println("Initializing Initable3");
    }
}
public class ClassInitialization {
    public static Random random=new Random(47);
        public static void main(String[] args) throws Exception {
        Class initable=Initable.class;
        System.out.println("After creating Initable ref");
        //调用时才初始化
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);
        //立刻初始化
        Class initable3=Class.forName("RTTI.Initiable3");
        System.out.println("After");
        System.out.println(Initiable3.staiticNonFinal);
    }
}
