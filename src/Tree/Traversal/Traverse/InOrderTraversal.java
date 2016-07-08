package Tree.Traversal.Traverse;

import java.util.ArrayList;

/**
 * Created by Frank on 16/7/6.
 */
public class InOrderTraversal {
    public ArrayList<Integer> inorderTraversal(Tree.Traversal.Traverse.TreeNode root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        if(root == null){
            return inOrder;
        }
        traverse(inOrder, root);
        return inOrder;
    }
    private void traverse(ArrayList<Integer> inOrder, TreeNode root){
        if(root == null){
            return;
        }
        traverse(inOrder, root.left);
        inOrder.add(root.val);
        traverse(inOrder, root.right);
    }
}
