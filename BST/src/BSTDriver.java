import java.util.List;

public class BSTDriver {

    private void go() {
        BST tree = new BST();
        List.of(25, 20, 36, 10, 22, 30, 40, 5, 12, 28, 38, 48, 1, 8, 15, 25, 45, 50).forEach(tree::insert);
        System.out.println(tree.printTree());
        System.out.println(tree.search(1));
        System.out.println(tree.search(15));
        System.out.println(tree.search(44));
        System.out.println("inOrder: " + tree.inOrder());
    }
    public static void main(String[] args) {
        new BSTDriver().go();
    }
}
