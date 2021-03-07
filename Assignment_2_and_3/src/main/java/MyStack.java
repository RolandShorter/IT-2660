
public class MyStack<T> extends MyArray<T> {

    public MyStack() {
        super();
    }

    public void push( T item) {
        add(item);
    }

    public T pop() {
        return remove(getSize() - 1);
    }

    public T peek() {
        return get(getSize() - 1);
    }
}
