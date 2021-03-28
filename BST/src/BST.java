public class BST {
    private Node root = null;
    private int size = 0;
    StringBuilder sb;

    public void insert(int i) {
        if (root != null && search(i)) return;    // duplicate
        Node node = new Node(i);
        if (root == null) {
            root = node;
            size++;
            return;
        }
        Node p = root;
        Node prev = null;
        while (p != null) {
            prev = p;
            if (i < p.data)
                p = p.left;
            else
                p = p.right;
        }
        if (i < prev.data)
            prev.left = node;
        else
            prev.right = node;
        size++;
    }

    public boolean search(int key) {
        Node p = root;
        while (p!= null) {
            if (key == p.data) return true;
            if (key < p.data)
                p = p.left;
            else
                p = p.right;
        }
        return false;
    }

    public String inOrder() {
        sb = new StringBuilder();
        sb.append("{");
        inOrder(root);
        sb.setLength(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }
    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        sb.append(node.data).append(", ");
        inOrder(node.right);
    }

    public String printTree() {return printTree(root, 0); }
    private String printTree(Node p, int depth) {
        StringBuilder sb = new StringBuilder();
        if (p != null) {
            sb.append(printTree(p.right, depth + 1));
            sb.append("     ".repeat(depth));
            sb.append(p.data).append("\n");
            sb.append(printTree(p.left, depth + 1));
        }
        return sb.toString();
    }

    class Node {
        int data;
        Node left, right;

        public Node(int i) {
            data = i;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}