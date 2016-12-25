package Tree.Basic;

import java.util.ArrayList;

/**
 * Created by Frank on 2016/12/22.
 */
public class LowestCommonAncestor2 {

    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here
        ParentTreeNode lca = null;

        ArrayList<ParentTreeNode> pathA = path(A);
        ArrayList<ParentTreeNode> pathB = path(B);

        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;

        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) break;
            lca = pathA.get(indexA);
            indexA--;
            indexB--;
        }
        return lca;
    }
    private ArrayList<ParentTreeNode> path(ParentTreeNode root) {
        ArrayList<ParentTreeNode> result = new ArrayList<>();
        if (root == null) return result;
        while (root != null) {
            result.add(root);
            root = root.parent;
        }
        return result;
    }
}
