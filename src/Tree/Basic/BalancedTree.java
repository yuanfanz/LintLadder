//package Tree.Basic;
//
///**
// * Created by yuanf on 2016/7/8.
// */
//class ResultType {
//    public boolean isBalanced;
//    public int maxDepth;
//    public ResultType(boolean isBalanced, int maxDepth) {
//        this.isBalanced = isBalanced;
//        this.maxDepth = maxDepth;
//    }
//}
//public class BalancedTree {
//    /**
//     * @param root: The root of binary tree.
//     * @return: True if this Binary tree is Balanced, or false.
//     */
//    public boolean isBalanced(TreeNode root) {
//        // write your code here
//        ResultType2 result = helper(root);
//        return result.isBalanced;
//    }
//    private ResultType2 helper(TreeNode root){
//        if (root == null){
//            return new ResultType2(true, 0);
//        }
//        //divide
//        ResultType2 left = helper(root.left);
//        ResultType2 right = helper(root.right);
//        //conquer
//        if(left.isBalanced && right.isBalanced && Math.abs(left.maxDepth - right.maxDepth) <= 1){
//            return new ResultType2(true, Math.max(left.maxDepth, right.maxDepth) + 1);
//        } else return new ResultType2(false, -1);
//    }
//}