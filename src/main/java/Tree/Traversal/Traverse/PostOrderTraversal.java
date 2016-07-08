package Tree.Traversal.Traverse;

import java.util.ArrayList;

/**
 * Created by yuanf on 2016/7/6.
 */
public class PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postOrder = new ArrayList<>();
        if (root == null){
            return postOrder;
        }
        traverse(postOrder, root);
        return postOrder;
    }
    private void traverse(ArrayList<Integer> postOrder, TreeNode root){
        if(root == null){
            return;
        }
        traverse(postOrder, root.left);
        traverse(postOrder, root.right);
        postOrder.add(root.val);
    }
}
