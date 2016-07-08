package Tree.Traversal.DivideAndConquer;

import java.util.ArrayList;

/**
 * Created by yuanf on 2016/7/6.
 */
public class PostOrderTraversal {
    public ArrayList<Integer> postOrderTraversal(TreeNode root){
        ArrayList<Integer> postOrder = new ArrayList<>();
        if(root == null){
            return postOrder;
        }
        //divide
        ArrayList<Integer> left = postOrderTraversal(root.left);
        ArrayList<Integer> right = postOrderTraversal(root.right);
        //conquer
        postOrder.addAll(left);
        postOrder.addAll(right);
        postOrder.add(root.val);
        return postOrder;
    }
}
