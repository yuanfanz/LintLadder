package Tree.DivideAndConquer;

import java.util.ArrayList;

/**
 * Created by yuanf on 2016/7/6.
 */
public class InOrderTraversal {
    public ArrayList<Integer> inOrderTraversal(TreeNode root){
        ArrayList<Integer> inOrder = new ArrayList<>();
        if(root == null){
            return inOrder;
        }
        //divide
        ArrayList<Integer> left = inOrderTraversal(root.left);
        ArrayList<Integer> right = inOrderTraversal(root.right);
        //conquer
        inOrder.addAll(left);
        inOrder.add(root.val);
        inOrder.addAll(right);
        return inOrder;
    }
}
