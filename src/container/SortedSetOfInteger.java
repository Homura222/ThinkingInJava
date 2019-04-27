package container;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SortedSetOfInteger {
    public static void main(String[] args){
    Random random=new Random(48);
    Set<Integer> intset=new TreeSet<Integer>();
    for (int i=0;i<10000;i++){
        intset.add(random.nextInt(29));
    }
    System.out.println(intset);
}
}
