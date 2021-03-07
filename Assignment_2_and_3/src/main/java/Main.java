
public class Main {
    public static void main( String[] args ) {
        new Main().go();
    }

    private void go() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        int i = stack.peek();
        System.out.println(i);
        i = stack.pop();
        System.out.println(i);

        MyQueue<String> queue = new MyQueue<>();
        queue.push("This");
        queue.push("is");
        queue.push("a");
        queue.push("list");
        queue.push("of");
        queue.push("strings");
        String s1 = queue.peek();
        System.out.println(s1);
        s1 = queue.pop();
        System.out.println(s1);
        String s2 = queue.pop();
        System.out.println(s2);

        MyDeque<String> deque = new MyDeque<>();
        deque.pushLast("This");
        deque.pushLast("is");
        deque.pushLast("a");
        deque.pushLast("list");
        deque.pushLast("of");
        deque.pushLast("strings");
        s1 = deque.peekFirst();
        System.out.println(s1);
        s1 = deque.popFirst();
        System.out.println(s1);
        s2 = deque.popLast();
        System.out.println(s2);
    }

}
