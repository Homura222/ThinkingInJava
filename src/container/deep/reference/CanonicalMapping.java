package container.deep.reference;

import java.util.WeakHashMap;

class Element {
    private String ident;

    public Element(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return "Element{" +
                "ident='" + ident + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return ident.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Element && ident.equals(((Element) obj).ident);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing" + getClass().getSimpleName() + "" + ident);
    }
}

class Key extends Element {
    public Key(String ident) {
        super(ident);
    }
}

class Value extends Element {
    public Value(String ident) {
        super(ident);
    }
}

public class CanonicalMapping {
    /**
     * gc后弱引用容器持有的对象都被回收
     * @param args
     */
    public static void main(String[] args) {
        int size = 1000;
        if (args.length > 0) {
            size = new Integer(args[0]);
        }
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0)
                keys[i] = k;
            map.put(k, v);
        }
        System.out.println(" ");
        System.gc();
        System.out.println(" ");
    }
}
