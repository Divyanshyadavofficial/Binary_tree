import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Average_of_levels {

    public static void main(String[] args) {
        TreeNode_avg root = new TreeNode_avg(1,
                new TreeNode_avg(2, new TreeNode_avg(4), new TreeNode_avg(5)),
                new TreeNode_avg(3));

        Solution_avg solution = new Solution_avg();
        List<Double> result = solution.AverageOfLevels(root);
        System.out.println(result);
    }

}
class TreeNode_avg {
    double val;
    TreeNode_avg left;
    TreeNode_avg right;

    TreeNode_avg() {
    }

    TreeNode_avg(int val) {
        this.val = val;
    }

    TreeNode_avg(int val, TreeNode_avg left, TreeNode_avg right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution_avg{
    public List<Double> AverageOfLevels(TreeNode_avg root){
        List<Double> result = new ArrayList<>();
        if(root == null){
            return  result;
        }
        Queue<TreeNode_avg> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            double sum = 0.0;
            for(int i =0;i<levelSize;i++){
                TreeNode_avg currentNode = queue.poll();
                sum+=currentNode.val;
                if(currentNode.left !=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right !=null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(sum/levelSize);
        }

        return result;
    }
}
