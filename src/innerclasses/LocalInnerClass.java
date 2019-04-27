package innerclasses;

interface Counter{
    int next();
}

/**
 * 局部内部类
 */
public class LocalInnerClass {
    private int count=0;
    //方法内的内部类对比
    Counter getCounter(final String name){
        class LocalCounter implements Counter{
            public LocalCounter() {
                System.out.println("LocalCounter()");
            }
            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        }
        return new LocalCounter();
    }
    Counter getCounter2(final String name){
        //匿名内部类不能有构造器
        //使用实例初始化手段充当构造器，但这不能替代构造器
        return new Counter() {
            {
                System.out.println("Counter()");
            }
            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        };
    }
    public static void main(String[] args){
        LocalInnerClass lic=new LocalInnerClass();
        Counter c1=lic.getCounter("Local inner"),c2=lic.getCounter2("Anonymous inner");
        for (int i=0;i<5;i++){
            System.out.println(c1.next());
        }
        for (int i=0;i<5;i++){
            System.out.println(c2.next());
        }
    }
}
