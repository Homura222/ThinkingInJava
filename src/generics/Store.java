package generics;

import RTTI.A;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

class Protect {
    private final int id;
    private String description;
    private double price;

    public Protect(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Protect{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Protect> generator = new Generator<Protect>() {
        private Random random = new Random(47);
        @Override
        public Protect next() {
            return new Protect(random.nextInt(1000), "Test",
                    Math.round(random.nextDouble() * 1000.0) + 0.99);
        }
    };
}

class Shelf extends ArrayList<Protect> {
    public Shelf(int nProducts) {
        Generators.fill(this, Protect.generator, nProducts);
    }
}

class Aisle extends ArrayList<Shelf> {
    public Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));
        }
    }
}

class CheckoutStand {
}

class Office {
}

public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkoutStands=new ArrayList<CheckoutStand>();
    private Office office=new Office();
    public Store(int nAisles,int nShelves,int nProducts){
        for (int i=0;i<nAisles;i++){
            add(new Aisle(nShelves,nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder results=new StringBuilder();
        for (Aisle a:this){
            for (Shelf s:a){
                for (Protect p:s) {
                    results.append(p);
                    results.append("\n");
                }
            }
        }
        return results.toString();
    }
    public static void main(String[] args){
        System.out.println(new Store(14,5,10));
    }
}
