package ReferenceCounting;


class Shard{
    private int reference=0;
    private static long counter=0;
    private final long id=counter++;
    //构造器
    public Shard() {
        System.out.println("Creating"+this);
    }
    //引用增加，当其他对象引用时调用
    public void addRef(){
        reference++;
    }
    //清除方法
    protected void dispose(){
        if (--reference==0){
            System.out.println("Disposing"+this);
        }
    }

    @Override
    public String toString() {
        return "Shard"+id;
    }
}
class Composing{
    private Shard shard;
    private static long counter=0;
    private final long id=counter++;
    //构造时增加shard的被引用数量
    public Composing(Shard shard) {
        System.out.println("Creating"+this);
        this.shard = shard;
        this.shard.addRef();
    }
    //清扫方法
    //成员类也清扫
    protected void dispose(){
        System.out.println("disposing"+this);
        shard.dispose();
    }

    @Override
    public String toString() {
        return "Composing"+id;
    }
}
public class ReferenceCounting {
    public static void main(String[] args){
        Shard shard=new Shard();
        //创建对象
        Composing[] composings={new Composing(shard),new Composing(shard),
                new Composing(shard),new Composing(shard),new Composing(shard)};
        //逐个清扫
        for (Composing c:composings)
            c.dispose();
    }
}
