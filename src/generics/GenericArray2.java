package generics;

public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int sz) {
        array=new Object[sz];
    }
    public void put(int index,T item){
        array[index]=item;
    }
    public T get(int index){
        return (T) array[index];
    }
    public T[] rep(){
        return (T[])array;
    }
    public static void main(String[] args){
        GenericArray2<Integer> gai=new GenericArray2<Integer>(10);
        for (int i=0;i<10;i++){
            gai.put(i,1);
        }
        for (int i=0;i<10;i++){
            System.out.println(gai.get(i)+"");
        }
        System.out.println();
        try {
            //尝试将Object[]转型为T[],异常
            //因此没有任何方式可以推翻底层的数组类型
            //元素可以转，数组类型不能
            Integer[] ia = gai.rep();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }

    }

}
