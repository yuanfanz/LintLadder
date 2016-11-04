package Search.BFS;

import java.util.ArrayList;

/**
 * Created by Frank on 2016/11/1.
 */
public class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
};