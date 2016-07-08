package Tree.Traversal.DivideAndConquer;

import java.util.ArrayList;

/**
 * Created by yuanf on 2016/7/6.
 */
public class PreOrderTraversal {
    public ArrayList<Integer> preOrderTraversal(TreeNode root){
        ArrayList<Integer> preOrder = new ArrayList<>();
        if (null == root){
            return preOrder;
        }
        //divide
        ArrayList<Integer> left = preOrderTraversal(root.left);
        ArrayList<Integer> right = preOrderTraversal(root.right);
        //conquer
        preOrder.add(root.val);
        preOrder.addAll(left);
        preOrder.addAll(right);
        return preOrder;
    }
}
