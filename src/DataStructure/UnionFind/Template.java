package DataStructure.UnionFind;

import java.util.HashMap;

/**
 * Created by Frank on 2016/11/13.
 */
public class Template {
    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<>();
        UnionFind(){}

        int find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }
        void union(int x, int y) {
            int fatherX = find(x);
            int fatherY = find(y);
            if (fatherX != fatherY) {
                father.put(fatherX, fatherY);
            }
        }
    }
}
