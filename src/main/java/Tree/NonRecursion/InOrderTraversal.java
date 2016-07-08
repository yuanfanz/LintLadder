package main.java.Tree.NonRecursion;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Frank on 16/7/6.
 */
public class InOrderTraversal {
    public ArrayList<Integer> inOrderTraversal(TreeNode root){
        ArrayList<Integer> inOrder = new ArrayList<>();
        if(root == null){
            return inOrder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curt =  root;
        while (curt != null || !stack.isEmpty()){
            while(curt != null){
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            inOrder.add(curt.val);
            curt = curt.right;
        }
        return inOrder;
    }
}
