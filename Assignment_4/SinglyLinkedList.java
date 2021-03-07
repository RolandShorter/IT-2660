/**
 * Singly SinglyLinkedList
 * Roland Shorter
 */
public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> curr;
    private Node<T> prev;
    int size = 0;
    int maxSize;

    public SinglyLinkedList() {
        maxSize = 10;
    }

    public SinglyLinkedList( int maxSize ) {
        this.maxSize = maxSize;
    }

    public void add( T item ) {
        Node<T> node = new Node<>(item);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void add( int index, T item ) {
        Node<T> node = new Node<>(item);
        if (tail == null || index > size - 1) {
            add(item);
            return;
        }

        if (index == 0) {
            node.next = head;
            head = node;
            size++;
            return;
        }
        int i = 0;
        curr = head;
        while (i++ < index) {
            prev = curr;
            curr = curr.next;
        }
        node.next = curr;
        // node.prev = prev;        // For doubly-linked list
        prev.next = node;
        // curr.prev = node;        // For doubly-linked list
        size++;
    }

    public T peekFirst() throws ListEmptyException {
        if (size == 0) throw new ListEmptyException();
        return head.data;
    }

    public T remove() throws ListEmptyException {
        if (isEmpty()) throw new ListEmptyException();
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public T remove( int index ) throws ListEmptyException {
        if (isEmpty()) throw new ListEmptyException();
        if (index > size - 1) return null;
        int i = 0;
        curr = head;
        while (i++ < index) {
            prev = curr;
            curr = curr.next;
        }
        T data = curr.data;
        prev.next = curr.next;
        // curr.next.prev = next;       // For doubly-linked list
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() { return size == 0;}

    public String toString() {
        if (isEmpty()) return "\n";
        StringBuilder sb = new StringBuilder();
        curr = head;
        while (curr != null) {
            sb.append(curr.data).append('\n');
            curr = curr.next;
        }
        return sb.toString();
    }
}
