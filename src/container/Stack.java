package container;

import java.util.LinkedList;

/**
 * 用LinkedList实现栈
 * @param <T>
 */
public class Stack<T> {
    private LinkedList<T> storage=new LinkedList<T>();
    public void push(T v){
        storage.addFirst(v);
    }
    public T peek(){
        return storage.getFirst();
    }
    public T pop(){
        return storage.removeFirst();
    }
    public boolean empty(){
        return storage.isEmpty();
    }
    @Override
    public String toString() {
        return storage.toString();
    }
}
