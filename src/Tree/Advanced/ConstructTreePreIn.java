package Tree.Advanced;

/**
 * Created by yuanfanz on 17/1/2.
 */
public class ConstructTreePreIn {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int preorderIndex,
                           int inStart, int inEnd) {
        if (inStart > inEnd || preorderIndex >= preorder.length) return null;

        int rootVal = preorder[preorderIndex];
        int pos = inStart;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == rootVal) {
                pos = i;
                break;
            }
        }
        int leftLength = pos - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, inorder, preorderIndex + 1, inStart, pos - 1);
        root.right = build(preorder, inorder, preorderIndex + leftLength + 1, pos + 1, inEnd);

        return root;
    }
}