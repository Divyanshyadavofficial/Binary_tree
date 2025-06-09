import java.util.*;
class TreeNode_zigzag {
    int val;
    TreeNode_zigzag left, right;

    TreeNode_zigzag(int val) {
        this.val = val;
    }
}

class ZigzagTraversal {

    public static List<Integer> zigzagTraversal(TreeNode_zigzag root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode_zigzag> deque = new LinkedList<>();
        deque.offer(root);
        boolean rev = false;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (!rev) {
                    TreeNode_zigzag node = deque.pollFirst();
                    level.add(node.val);
                    if (node.left != null) deque.offerLast(node.left);
                    if (node.right != null) deque.offerLast(node.right);
                } else {
                    TreeNode_zigzag node = deque.pollLast();
                    level.add(node.val);
                    if (node.right != null) deque.offerFirst(node.right);
                    if (node.left != null) deque.offerFirst(node.left);
                }
            }

            result.addAll(level);
            rev = !rev;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode_zigzag root = new TreeNode_zigzag(1);
        root.left = new TreeNode_zigzag(2);
        root.right = new TreeNode_zigzag(3);
        root.left.left = new TreeNode_zigzag(4);
        root.left.right = new TreeNode_zigzag(5);
        root.right.left = new TreeNode_zigzag(6);
        root.right.right = new TreeNode_zigzag(7);
        root.left.left.left = new TreeNode_zigzag(8);
        root.left.left.right = new TreeNode_zigzag(9);
        root.right.right.left = new TreeNode_zigzag(10);
        root.right.right.right = new TreeNode_zigzag(11);

        List<Integer> result = zigzagTraversal(root);
        System.out.println(result);
    }
}
