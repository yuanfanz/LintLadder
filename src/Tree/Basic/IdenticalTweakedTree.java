package Tree.Basic;

/**
 * Created by yuanf on 2016/7/9.
 */
public class IdenticalTweakedTree {
    /**
     * @param a, b, the root of binary trees.
     * @return true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        if(a.val != b.val){
            return false;
        }
        if(isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)){
            return true;
        }
        if(isTweakedIdentical(a.right, b.left) && isTweakedIdentical(a.left, b.right)){
            return true;
        }
        return false;
    }
}