
public class MyDeque<T> extends MyArray<T> {
    public MyDeque() {
        super();
    }

    public void pushFirst(T item) {
        add(item, 0);
    }

    public void pushLast(T item) {
        add(item);
    }

    public T popFirst() {
        return remove(0);
    }

    public T popLast() {
        return remove(getSize() - 1);
    }

    public T peekFirst() {
        return get(0);
    }

    public T peekLast() {
        return get(getSize() - 1);
    }

}

