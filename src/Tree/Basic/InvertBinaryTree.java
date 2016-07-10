package Tree.Basic;

/**
 * Created by yuanf on 2016/7/9.
 */
public class InvertBinaryTree {
        /**
         * @param root: a TreeNode, the root of the binary tree
         * @return: nothing
         */
        public void invertBinaryTree(TreeNode root) {
            // write your code here
            if(root == null){
                return;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertBinaryTree(root.left);
            invertBinaryTree(root.right);
        }
    }
