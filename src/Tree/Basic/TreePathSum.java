package Tree.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuanf on 2016/7/11.
 */
public class TreePathSum {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum1(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            ArrayList<Integer> trav = new ArrayList<Integer>();
            TreeNode head = stack.pop();
            trav.add(head.val);
            int size = trav.size();
            int re = 0;
            for(int i = 0; i < size; ++i){
                re += trav.get(i);
            }
            if(re == target){
                result.add(trav);
                break;
            }
            if(root.left != null){
                stack.push(head.left);
            }
            if(root.right != null){
                stack.push(head.right);
            }
        }
        return result;
    }

    public void main(String args[]){
        
    }

    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        helper(root, target, result, path, root.val);
        return result;
    }
    private void helper(TreeNode root, int target, List<List<Integer>> result,
                        ArrayList<Integer> path, int sum){

        if(root.left == null && root.right == null){
            if(sum == target){
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        if(root.left != null){
            path.add(root.left.val);
            helper(root.left, target, result, path, sum + root.left.val);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            path.add(root.right.val);
            helper(root.right, target, result, path, sum + root.right.val);
            path.remove(path.size() - 1);
        }
    }
}