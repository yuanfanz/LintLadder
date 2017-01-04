package Tree.BST;

/**
 * Created by Frank on 16/7/14.
 */

import Tree.Advanced.*;

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
    private Stack<Tree.Advanced.TreeNode> stack = new Stack<Tree.Advanced.TreeNode>();
    private Tree.Advanced.TreeNode curt;

    //@param root: The root of binary tree.
    public BSTIterator(Tree.Advanced.TreeNode root) {
        // write your code here
        curt = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return (curt != null || !stack.isEmpty());
    }

    //@return: return next node
    public Tree.Advanced.TreeNode next() {
        // write your code here
        while(curt != null){
            stack.push(curt);
            curt = curt.left;
        }
        curt = stack.pop();
        Tree.Advanced.TreeNode node = curt;
        curt = curt.right;

        return node;
    }
}