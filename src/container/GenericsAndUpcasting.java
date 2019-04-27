package container;

import java.util.ArrayList;

class GrannySmith extends Apple{}

class Gala extends Apple{}

class Fuji extends Apple{}

class Braeburn extends Apple{}

public class GenericsAndUpcasting {
    public static void main(String[] args){
        ArrayList<Apple> apples=new ArrayList<Apple>();
        //泛型父类也可以
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for(Apple c:apples){
            System.out.println(c);
        }
    }
}
