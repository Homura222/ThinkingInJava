package generics;

import java.util.ArrayList;
import java.util.List;

public class ErasedTypeEquivalence {
    private void setList(List list){
        list.add("1234");
        list.add(123);
    }
    public static void main(String[] args){
        //两个类型相同
        Class c1=new ArrayList<String>().getClass();
        Class c2=new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);

        List<String> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        list1.add("23");
        //以下代码编译不通过
//        list1.add(123);
        list2.add(123);
//        list2.add("123");
        ErasedTypeEquivalence erasedTypeEquivalence=new ErasedTypeEquivalence();
        erasedTypeEquivalence.setList(list1);
        erasedTypeEquivalence.setList(list2);
        System.out.println("list1:");
        for (Object o:list1){
            System.out.println(o.getClass().getName());
        }
        System.out.println("list2:");
        for (Object o:list2){
            System.out.println(o.getClass().getName());
        }
        System.out.println(list1+"--"+list2);
    }
}
