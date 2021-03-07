
public class MyQueue<T> extends MyArray<T> {

    public MyQueue() {
        super();
    }

    public void push(T item) {
        add(item);
    }

    public T pop() {
        return remove(0);
    }

    public T peek() {
        return get(0);
    }
}
