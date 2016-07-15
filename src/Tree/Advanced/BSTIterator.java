package Tree.Advanced;

/**
 * Created by Frank on 16/7/14.
 */

import java.util.Stack;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private TreeNode curt;

    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        // write your code here
        curt = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return (curt != null || !stack.isEmpty());
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        while(curt != null){
            stack.push(curt);
            curt = curt.left;
        }
        curt = stack.pop();
        TreeNode node = curt;
        curt = curt.right;

        return node;
    }
}