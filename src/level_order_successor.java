import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class level_order_successor {
    public static void main(String[] args) {

            TreeNode_successor root = new TreeNode_successor(1,
                    new TreeNode_successor(2, new TreeNode_successor(4), new TreeNode_successor(5)),
                    new TreeNode_successor(3));
            int key =2;

            Solution_successor solution = new Solution_successor();
            TreeNode_successor result = solution.FindSuccessor(root,key);
        if (result != null) {
            System.out.println("Level order successor of " + key + " is: " + result.val);
        } else {
            System.out.println("No successor found for " + key);
        }
    }
}

class TreeNode_successor {
    int val;
    TreeNode_successor left;
    TreeNode_successor right;

    TreeNode_successor() {
    }

    TreeNode_successor(int val) {
        this.val = val;
    }

    TreeNode_successor(int val, TreeNode_successor left, TreeNode_successor right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution_successor{
    public TreeNode_successor FindSuccessor (TreeNode_successor root,int key) {

        if (root == null) {
            return null;
        }
        Queue<TreeNode_successor> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode_successor currentNode = queue.poll();
            if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
            if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            if(currentNode.val == key){
                break;
            }
            }
        return queue.peek();



    }
}