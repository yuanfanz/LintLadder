package Search.BFS;

import java.util.ArrayList;

/**
 * Created by Frank on 2016/11/1.
 */
class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x; neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
