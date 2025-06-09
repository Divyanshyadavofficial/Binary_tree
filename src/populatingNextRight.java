class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class populatingNextRight {
    public static void main(String[] args) {
        // Create a perfect binary tree (for testing)
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        populatingNextRight solution = new populatingNextRight();
        Node connectedRoot = solution.connect(root);

        // Optional: print level-wise connections
        printConnections(connectedRoot);
    }

    public Node connect(Node root) {
        if (root == null) return null;

        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;

            while (current != null) {
                current.left.next = current.right;

                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }

            leftMost = leftMost.left;
        }

        return root;
    }

    // Helper method to print next pointers level-wise
    private static void printConnections(Node root) {
        while (root != null) {
            Node current = root;
            while (current != null) {
                System.out.print(current.val + " -> ");
                if (current.next != null)
                    System.out.print(current.next.val + "   ");
                else
                    System.out.print("null   ");
                current = current.next;
            }
            System.out.println();
            root = root.left;
        }
    }
}


