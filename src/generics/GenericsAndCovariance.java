package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}

public class GenericsAndCovariance {
    public static void main(String[] args){
        //不能这么用
        List<? extends Fruit> fruits=new ArrayList<Fruit>();
//        fruits.add(new Apple());
//        fruits.add(new Fruit());
//        fruits.add(new Object());
//        Object[] objects=(Object[]) new int[10];
        fruits.add(null);
        Fruit f=fruits.get(0);
    }
}
