import java.util.Arrays;

/**************************************************************
 * Roland Shorter
 ***************************************************************/

public class SinglyLinkedListDriver {
    public static void main( String[] args ) {
        new SinglyLinkedListDriver().go();
    }

    private void go() {
        SinglyLinkedList<Double> ll = new SinglyLinkedList<>();
        try {
            for ( double d : Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5) ) {
                ll.add(d);
            }
            System.out.println("Added 5 items: ");
            System.out.println(ll);

            System.out.println("Adding item at position 2");
            ll.add(2, 2.5);
            System.out.println(2.5 + " added.");
            System.out.println("Size is " + ll.size());
            System.out.println("List is now:");
            System.out.println(ll);

            System.out.println("Testing removals");
            System.out.println("First item is " + ll.peekFirst());
            System.out.println("First item removed: " + ll.remove());
            System.out.println("List is now:");
            System.out.println(ll);

            System.out.println("Item at index 2 removed: " + ll.remove(2));
            System.out.println("List is now:");
            System.out.println(ll);
        }
        catch (ListEmptyException e) {
            e.printStackTrace();
        }

        System.out.println("Testing exceptions");

        try {
            System.out.println("Removed " + ll.remove());
            System.out.println("Removed " + ll.remove());
            System.out.println("Removed " + ll.remove());
            System.out.println("Removed " + ll.remove());
            System.out.println("Removed " + ll.remove());
        } catch (ListEmptyException e) {
            System.out.println("List Empty Exception on 5th remove operation.");
        }
        System.out.println("List is now:");
        System.out.println(ll);

    }
}
