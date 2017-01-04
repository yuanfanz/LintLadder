package Tree.BST;

import java.util.ArrayList;

/**
 * Created by yuanfanz on 17/1/3.
 */
public class SearchRangeBST {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        helper(result, root, k1, k2);
        return result;
    }
    private void helper(ArrayList<Integer> result, TreeNode root, int k1, int k2) {
        if (root == null) return;

        if (root.val > k1) {
            helper(result, root.left, k1, k2);
        }
        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }
        if (root.val < k2) {
            helper(result, root.right, k1, k2);
        }
    }
}
