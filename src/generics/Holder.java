package generics;

public class Holder<T> {
    private T value;

    public Holder() {
    }

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean equals(Object object) {
        return value.equals(object);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<Apple>(new Apple());
        Apple d = apple.getValue();
        apple.setValue(d);
        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.getValue();
        d = (Apple) fruit.getValue();
        //无法使用该方法，因为泛型变成"? extend Fruit"
//        fruit.setValue(new Apple());
//        fruit.setValue(new Fruit());
        System.out.println(fruit.equals(d));
    }
}
