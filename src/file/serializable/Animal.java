package file.serializable;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private House preferredHouse;

    public Animal(String nm, House h) {
        this.name = nm;
        this.preferredHouse = h;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", preferredHouse=" + preferredHouse +
                '}';
    }
}
