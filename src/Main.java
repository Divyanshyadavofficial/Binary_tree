import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Main{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));

        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }
}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val) {this.val=val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }


}
class Solution{
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return  result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentlevel = new ArrayList<>();
            for(int i =0;i<levelSize;i++){
                TreeNode currentNode = queue.poll();
                currentlevel.add(currentNode.val);
                if(currentNode.left !=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right !=null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentlevel);
        }

        return result;
    }
}