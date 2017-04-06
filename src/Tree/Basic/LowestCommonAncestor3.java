package Tree.Basic;

/**
 * Created by yuanfanz on 17/3/31.
 */
class ResultType {
    public boolean aexist, bexist;
    public TreeNode lca;
    ResultType (boolean a, boolean b, TreeNode node) {
        aexist = a;
        bexist = b;
        lca = node;
    }
}
public class LowestCommonAncestor3 {
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || A == null || B == null) return null;
        ResultType result = helper(root, A, B);
        if (result.aexist && result.bexist) {
            return result.lca;
        } else return null;
    }
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) return new ResultType(false, false, root);

        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);

        boolean aexist = root == A || left.aexist || right.aexist;
        boolean bexist = root == B || left.bexist || right.bexist;

        if (root == A || root == B) return new ResultType(aexist, bexist, root);

        if (left.lca != null && right.lca != null) return new ResultType(aexist, bexist, root);
        if (left.lca != null) return new ResultType(aexist, bexist, left.lca);
        if (right.lca != null) return new ResultType(aexist, bexist, right.lca);

        return new ResultType(aexist, bexist, null);
    }
}
