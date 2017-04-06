package Tree.Advanced;

/**
 * Created by yuanfanz on 17/4/2.
 */
public class Diameter {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int dia = maxDepth(root.left) + maxDepth(root.right);
        int ldia = diameterOfBinaryTree(root.left);
        int rdia = diameterOfBinaryTree(root.right);
        return Math.max(dia, Math.max(ldia, rdia));
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

class Solution2 {
    class ResultType{
        int root2Any;
        int any2Any;
        public ResultType(int root2Any, int any2Any){
            this.root2Any = root2Any;
            this.any2Any = any2Any;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        ResultType result = helper(root);
        return result.any2Any;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int root2Any = Math.max(left.root2Any, right.root2Any) + 1;
        int any2Any = Math.max(left.any2Any, right.any2Any);

        any2Any = Math.max(any2Any, left.root2Any + right.root2Any);

        return new ResultType(root2Any, any2Any);
    }
}
