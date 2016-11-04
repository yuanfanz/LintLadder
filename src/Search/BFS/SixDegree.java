package Search.BFS;

import java.util.*;

/**
 * Created by Frank on 2016/11/1.
 */
public class SixDegree {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (graph == null || s == null || t == null) {
            return -1;
        }
        if (s == t) {
            return 0;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashMap<UndirectedGraphNode, Integer> map = new HashMap<>();
        queue.offer(s);
        map.put(s, 0);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode n : head.neighbors) {
                if (!map.containsKey(n)) {
                    queue.offer(n);
                    map.put(n, map.get(head) + 1);
                    if (n == t) {
                        return map.get(n);
                    }
                }
            }
        }
        return -1;
    }
}