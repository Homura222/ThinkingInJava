package innerclasses;

public class Parcel5 {
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;

            public PDestination(String label) {
                this.label = label;
            }

            @Override
            public String readLabel() {
                return label;
            }

            @Override
            public String toString() {
                return "PDestination{" +
                        "label='" + label + '\'' +
                        '}';
            }
        }
        return new PDestination(s);
    }
    public static void main(String args[]){
        Parcel5 p=new Parcel5();
        Destination d=p.destination("Tasmania");
        System.out.println(d);
    }
}
