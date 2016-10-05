public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n < 1 || edges == null || edges.length == 0 || edges[0].length == 0) return n;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int p1 = find(edge[0], parent);
            int p2 = find(edge[1], parent);
            if (p1 != p2) {
                parent[p1] = p2;
                n--;
            }
        }
        return n;
    }
    
    private int find(int p, int[] parent) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}