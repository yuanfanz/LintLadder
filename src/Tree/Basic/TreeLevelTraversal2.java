package Tree.Basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by yuanf on 2016/7/11.
 */
public class TreeLevelTraversal2 {
    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode head = queue.poll();
                level.add(head.val);
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            stack.push(level);
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        //Collections.reverse(result);
        //直接reverse整个list也是可以的 更懒一些
        return result;
    }
}
