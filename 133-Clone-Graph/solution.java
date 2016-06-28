/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(node.label, res);
        for (UndirectedGraphNode n : node.neighbors) {
            UndirectedGraphNode nb = map.get(n.label);
            if (nb == null)
                nb = dfs(n, map);
            res.neighbors.add(nb);
        }
        return res;
    }
}