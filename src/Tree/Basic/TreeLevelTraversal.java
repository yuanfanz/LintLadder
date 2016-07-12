package Tree.Basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuanf on 2016/7/11.
 */
public class TreeLevelTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> level = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return level;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> result = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode head = queue.poll();
                result.add(head.val);
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            level.add(result);
        }
        return level;
    }
}