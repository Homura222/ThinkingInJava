package container.deep;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Groundhog {
    protected int number;

    public Groundhog(int number) {
        this.number = number;
    }

    //添加以下两个方法后生效
    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Groundhog &&(number==((Groundhog) obj).number);
    }

    @Override
    public String toString() {
        return "Groundhog{" +
                "number=" + number +
                '}';
    }
}

class Prediction{
    private static Random random=new Random(47);
    private boolean shadow =random.nextDouble()>0.5;

    @Override
    public String toString() {
        if (shadow)
            return "Six more weeks of Winner";
        else
            return "Early Spring";
    }
}

public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> ghog=type.getConstructor(int.class);
        Map<Groundhog,Prediction> map=new HashMap<Groundhog,Prediction>();
        for (int i=0;i<10;i++){
            map.put(ghog.newInstance(i),new Prediction());
        }
        System.out.println("map="+map);
        Groundhog gh=ghog.newInstance(3);
        System.out.println("Looking up prediction for"+gh);
        //无法找到，原因是在Object中hashcode的判断，两个3的hashcode不一样
        //若要正常运行需要编写hashcode方法和equals方法
        if (map.containsKey(gh))
            System.out.println(map.get(gh));
        else
            System.out.println("Key not found:"+gh);
    }
    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
    }
}
