import java.util.Arrays;

public class MyArray<T> {
    private int max = 10;
    private int size = -1;
    private T[] array;

    public MyArray() {
        array = (T[]) new Object[max];
    }

    public int getSize() {
        return size + 1;
    }

    public void add(T item) {
        size++;
        if (size == max) resize();
        array[size] = item;
    }

    public T get(int pos) {
        return array[pos];
    }

    private void resize() {
        max *= 2;
        T[] newArray = ( T[] ) new Object[max];
        for ( int i = 0; i < size; i++ ) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void add( T item, int pos ) {
        size++;
        if (size == max) resize();
        for ( int i = size; i > pos; i-- ) {
            array[i] = array[i - 1];
        }
        array[pos] = item;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public T remove( int pos ) {
        T rem = array[pos];
        for ( int i = pos; i < size; i++ ) {
            array[i] = array[i + 1];
        }
        array[size] = null;
        size--;
        return rem;
    }

    public String printArray() {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i <= size; i++ ) {
            sb.append(array[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

}
