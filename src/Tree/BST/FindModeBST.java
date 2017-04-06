package Tree.BST;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanfanz on 17/4/4.
 */
public class FindModeBST {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count < entry.getValue()) {
                count = entry.getValue();
            }
        }
        int count2 = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count == entry.getValue()) {
                count2++;
            }
        }
        int[] result = new int[count2];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count == entry.getValue()) {
                result[count2 - 1] = entry.getKey();
                count2--;
            }
        }
        return result;
    }
    private void helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        helper(root.left, map);
        helper(root.right, map);
        if (!map.containsKey(root.val)) {
            map.put(root.val, 1);
        } else {
            map.put(root.val, map.get(root.val) + 1);
        }
    }
}
