package Tree.NonRecursion;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Frank on 16/7/6.
 */
public class InOrderTraversal {
    public ArrayList<Integer> preorderTraversal(Tree.NonRecursion.TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        if(root == null){
            return inOrder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            inOrder.add(node.val);
        }
    }
}
