package generics;

class Generic<T> {
}

public class ArraryOfGeberic {
    static final int SIZE = 100;

    static Generic<Integer>[] gia;
    @SuppressWarnings("unchecked")
    //可以编译但是不能运行
    public static void main(String[] args){

//        gia=(Generic<Integer>[]) new Object[SIZE];
        gia=(Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0]=new Generic<Integer>();
        //泛型检查
//        gia[1]=new Object();
//        gia[2]=new Generic<Double>();
    }
}
