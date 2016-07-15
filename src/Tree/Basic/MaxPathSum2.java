package Tree.Basic;

/**
 * Created by Frank on 16/7/12.
 */
class ResultType3 {
    int root2Any, any2Any;
    ResultType3(int root2Any, int any2Any){
        this.root2Any = root2Any;
        this.any2Any = any2Any;
    }
}
public class MaxPathSum2 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        ResultType3 result = helper(root);
        return result.any2Any;
    }
    private ResultType3 helper(TreeNode root){
        if(root == null){
            return new ResultType3(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        ResultType3 left = helper(root.left);
        ResultType3 right = helper(root.right);

        int root2Any = Math.max(0, Math.max(left.root2Any, right.root2Any)) + root.val;

        /**
         * "any node to any node" 有三种情况:
         * 1. 要么全在左子树
         * 2. 要么全在右子树
         * 3. 要么跨过根节点
         *
         * 跨过根节点: 拆成根节点左右两部分----左root to any 和 右root to any
         *           总共三部分: left.root2Any + right.root2Any + root.val
         *
         * 需要解决的就是判断1 2 3谁最大,就返回谁。
         * 所以先比较全左(1)和全右(2)的情况, 比较大的和跨过根节点情况(3)相比。
         */

        int any2Any = Math.max(left.any2Any, right.any2Any);  //先比较全左(1)和全右(2)的情况
        any2Any = Math.max(any2Any,
                            Math.max(0, left.root2Any) +
                            Math.max(0, right.root2Any) + root.val);  //比较大的和跨过根节点情况(3)相比

        return new ResultType3(root2Any, any2Any);
    }
}