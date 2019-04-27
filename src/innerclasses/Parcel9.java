package innerclasses;

public class Parcel9 {
    public Destination destination(final String dest){
        return new Destination() {
            //初始化
            private String lable=dest;
            @Override
            public String readLabel() {
                return lable;
            }
        };
    }
    public static void main(String[] args){
        Parcel9 p=new Parcel9();
        Destination d=p.destination("Tasmania");
    }
}
