package innerclasses;

public class Paecel7 {
    public Contents contents(){
        return new Contents() {
            private int i=11;
            @Override
            public int values() {
                return i;
            }
        };
    }
    public static void main(String args[]){
        Paecel7 p=new Paecel7();
        Contents contents=p.contents();
        System.out.println(contents.values());
    }
}
//以上匿名类效果等同于以下类
class Parcel7b{
    class MyContents implements Contents{
        private int i=11;
        @Override
        public int values() {
            return i;
        }
    }
    public Contents contents(){
        return new MyContents();
    }
    public static void main(String args[]){
        Parcel7b p=new Parcel7b();
        Contents c=p.contents();
    }
}