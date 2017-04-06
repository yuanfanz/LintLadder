package Tree.Basic;

import Tree.Advanced.ConstructTreePreIn;

import java.util.ArrayList;

/**
 * Created by yuanfanz on 17/3/31.
 */
public class Solution {
    public static boolean hasPathSum(Tree.Advanced.TreeNode root, int sum) {
        if (root == null) return false;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, result, path);
        for (ArrayList<Integer> p : result) {
            int res = 0;
            for (int i = 0; i < p.size(); i++) {
                res += p.get(i);

                System.out.print(p.get(i) + " ");
            }
            System.out.println("");
            if (res == sum) return true;
        }
        return false;
    }
    private static void dfs (Tree.Advanced.TreeNode root, ArrayList<ArrayList<Integer>> result,
                      ArrayList<Integer> path) {
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            dfs(root.left, result, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            dfs(root.right, result, path);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String args[]) {
        int[] preOrder = {1,2,4,5,3,6,7};
        int[] inOrder = {4,2,5,1,6,3,7};
        Tree.Advanced.TreeNode root = ConstructTreePreIn.buildTree(preOrder, inOrder);
        boolean res = hasPathSum(root, 11);

    }
}