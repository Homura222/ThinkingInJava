package generics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CompileIntelligence {
    public static void main(String[] args){
        List<? extends Fruit> fruits= Arrays.asList(new Apple());
        Apple a=(Apple) fruits.get(0);
        System.out.println(fruits.get(0).getClass().getSimpleName());
        System.out.println(a.getClass().getSimpleName());
        System.out.println(fruits.contains(new Apple())+"*****"+fruits.indexOf(new Apple()));
        System.out.println(fruits.contains(new Fruit())+"*****"+fruits.indexOf(new Fruit()));
        System.out.println(fruits.contains(a)+"*****"+fruits.indexOf(a));
    }
}
