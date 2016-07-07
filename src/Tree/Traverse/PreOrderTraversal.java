package Tree.Traverse;

import java.util.ArrayList;

/**
 * Created by Frank on 16/7/6.
 */
public class PreOrderTraversal {
    public ArrayList<Integer> preorderTraversal(Tree.Traverse.TreeNode root) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        if (root == null) {
            return preOrder;
        }
        traverse(preOrder, root);
        return preOrder;
    }
    private void traverse(ArrayList<Integer> preOrder, Tree.Traverse.TreeNode root){
        if(root == null){
            return;
        }
        preOrder.add(root.val);
        traverse(preOrder, root.left);
        traverse(preOrder, root.right);
    }
}
