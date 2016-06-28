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
        if (node == null) {
            return node;
        }
        Map<Integer, UndirectedGraphNode> labelToNode = new HashMap<>();
        ArrayDeque<UndirectedGraphNode> queue = new ArrayDeque<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode crt = queue.poll();
            visited.add(crt);
            UndirectedGraphNode clonedNode = labelToNode.get(crt.label);
            if (clonedNode == null) {
                clonedNode = new UndirectedGraphNode(crt.label);
                labelToNode.put(crt.label, clonedNode);
            }
            for (UndirectedGraphNode un : crt.neighbors) {
                UndirectedGraphNode newNode = labelToNode.get(un.label);
                if (newNode == null) {
                    newNode = new UndirectedGraphNode(un.label);
                    labelToNode.put(un.label, newNode);
                }
                
                clonedNode.neighbors.add(newNode);
                if (!visited.contains(un)) {
                    queue.add(un);
                    visited.add(un);
                }
            }
            
        }
        return labelToNode.get(node.label);
    }
}