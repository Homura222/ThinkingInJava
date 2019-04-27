package container.deep;


import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class SetType {
    int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && (i == ((SetType) obj).i);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class HashType extends SetType {
    public HashType(int i) {
        super(i);
    }

    public int hashCode() {
        return i;
    }
}

class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeType o) {
        return (o.i < i ? -1 : (o.i == i ? 0 : 1));
    }
}

public class TypesForSets {
    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try {
            for (int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return set;
    }
    static <T> void test(Set<T> set,Class<T> type){
        fill(set,type);
        fill(set,type);
        fill(set,type);
        System.out.println(set);
    }
    public static void main(String[] args){
        //以某种神秘的顺序保存
         test(new HashSet<HashType>(),HashType.class);
         //按照插入顺序保存
         test(new LinkedHashSet<HashType>(),HashType.class);
         //按照排序顺序维护元素，按照compareTo的实现方式
         test(new TreeSet<TreeType>(),TreeType.class);
         //don't work,SetType和TreeType没有定义hashcode方法，导致插入重复元素
         test(new HashSet<SetType>(),SetType.class);
         test(new LinkedHashSet<SetType>(),SetType.class);
         test(new LinkedHashSet<TreeType>(),TreeType.class);

         //以下SetType和TreeType没有实现Comparable接口
         try {
             test(new TreeSet<SetType>(), SetType.class);
         }catch (Exception e){
             System.out.println(e.getMessage());
         }

         try {
             test(new TreeSet<HashType>(), HashType.class);
         }catch (Exception e){
             System.out.println(e.getMessage());
         }

    }

}
