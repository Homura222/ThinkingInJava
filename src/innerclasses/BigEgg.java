package innerclasses;

class Egg{
    private Yolk y;
    protected class Yolk{
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    public Egg() {
        System.out.println("New Egg()");
        y=new Yolk();
    }
}
public class BigEgg extends Egg{
    public class Yolk{
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }
    //输出的不是覆盖后的版本
    public static void main(String [] args){
        new BigEgg();
    }
}
