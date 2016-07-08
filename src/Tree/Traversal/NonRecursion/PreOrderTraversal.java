package Tree.Traversal.NonRecursion;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Frank on 16/7/6.
 */
public class PreOrderTraversal {
    public ArrayList<Integer> preorderTraversal(Tree.Traversal.NonRecursion.TreeNode root) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        if(root == null){
            return preOrder;
        }
        Stack<Tree.Traversal.NonRecursion.TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Tree.Traversal.NonRecursion.TreeNode node = stack.pop();
            preOrder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preOrder;
    }
}
