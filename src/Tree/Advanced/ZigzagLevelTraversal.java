package Tree.Advanced;

import java.util.ArrayList;

/**
 * Created by yuanfanz on 17/1/3.
 */
public class ZigzagLevelTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.get(i);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (level % 2 == 0) {
                for (int i = size - 1; i >= 0; --i) {
                    TreeNode node = queue.get(i);
                    list.add(node.val);
                    queue.remove(i);
                }
            } else {
                for (int i = 0; i < size; ++i) {
                    TreeNode node = queue.get(0);
                    list.add(node.val);
                    queue.remove(0);
                }
            }
            result.add(list);
            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        String data = "{1,2,3,4,#,#,5,#,#,6,7,#,#,#,8}";
        TreeNode root = Serialize.deserialize(data);
        ArrayList<ArrayList<Integer>> result = zigzagLevelOrder(root);
        System.out.print("[");
        System.out.print(" ");
        for (ArrayList<Integer> list : result) {
            System.out.print("[");

            for(Integer i : list) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.print("]");
        }
        System.out.print(" ");
        System.out.print("]");
        System.out.println("");
        System.out.print("********************");

    }
}