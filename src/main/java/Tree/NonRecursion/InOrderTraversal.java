package Tree.NonRecursion;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Frank on 16/7/6.
 */
public class InOrderTraversal {
    public ArrayList<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        if(root == null){
            return inOrder;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        while(curt != null){
            stack.push(curt);
            curt = curt.left;
        }
        inOrder.add(stack.pop().val);
        inOrder.add(root.val);

    }
}
