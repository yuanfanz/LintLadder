package Tree.Advanced;

/**
 * Created by yuanfanz on 17/1/2.
 */
public class ConstructTreeInPost {
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder, int postIndex,
                           int inStart, int inEnd) {
        if (inStart > inEnd || postIndex < 0) return null;

        int rootVal = postorder[postIndex];
        int pos = inStart;
        for (int i = inStart; i <= inEnd; ++i) {
            if (rootVal == inorder[i]) {
                pos = i;
                break;
            }
        }
        int rightLength = inEnd - pos;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, postorder, postIndex - rightLength - 1, inStart, pos - 1);
        root.right = build(inorder, postorder, postIndex - 1, pos + 1, inEnd);

        return root;
    }
}